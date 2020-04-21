package com.cxytiandi.kittycloud.aggregation.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cxytiandi.kittycloud.aggregation.service.ApiMetaDataService;
import com.cxytiandi.kittycloud.aggregation.request.HttpAggregationRequest;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import com.cxytiandi.kittycloud.aggregation.worker.HttpWorker;
import com.jd.platform.async.executor.Async;
import com.jd.platform.async.executor.timer.SystemClock;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 22:41
 */
@Component
public class HttpApiAggregator {

    @Autowired
    private ApiMetaDataService apiMetaDataService;

    public Object apiAggregator(String apiName, HttpServletRequest request) {
        HttpAggregationRequest httpAggregationRequest = apiMetaDataService.getHttpAggregationRequest(apiName);
        List<HttpRequest> httpRequests = httpAggregationRequest.getHttpRequests();

        httpRequests.forEach( req -> {
            Map paramsMap = new HashMap<>();
            String params = req.getParams();
            if (StringUtils.hasText(params)) {
                paramsMap = JSONObject.parseObject(params, Map.class);
            }
            Set<String> paramKeys = paramsMap.keySet();
            for(String k : paramKeys) {
                Object value = paramsMap.get(k);
                if (value.toString().startsWith("$request")) {
                    String param = value.toString().split("\\.")[1];
                    String parameter = request.getParameter(param);
                    paramsMap.put(k, parameter);
                }

            }
            req.setParamsValueMap(paramsMap);
        });

        Map<String, WorkResult<JSONObject>> workResultMap = new HashMap<>();
        Map<WorkerWrapper, String> workerWrapperStringMap = new HashMap<>();
        Map<String, WorkerWrapper> workerWrapperStringMap2 = new HashMap<>();

        List<HttpRequest> requests = httpRequests.stream().filter(hr -> StringUtils.isEmpty(hr.getRef())).collect(Collectors.toList());
        List<WorkerWrapper<HttpRequest, JSONObject>> workerWrappers = a(requests, httpRequests, workerWrapperStringMap2);


        for (HttpRequest httpRequest : httpRequests) {
            WorkerWrapper<HttpRequest, JSONObject> workerWrapper = workerWrapperStringMap2.get(httpRequest.getName());

            WorkerWrapper<HttpRequest, JSONObject> workerWrapper1 = workerWrapperStringMap2.get(httpRequest.getRef());
            if (workerWrapper1 != null) {
                httpRequest.setWorkResult(workerWrapper1.getWorkResult());
            }

            workerWrapper.setParam(httpRequest);
        }

        long now = SystemClock.now();
        System.out.println("begin-" + now);
        try {
            Async.beginWork(100000, workerWrappers.toArray(new WorkerWrapper[workerWrappers.size()]));
            List<WorkResult> workResults = workerWrappers.stream().map(wrapper -> {
                WorkResult<JSONObject> workResult = wrapper.getWorkResult();
                String apiUri = workerWrapperStringMap.get(wrapper);
                workResultMap.put(apiUri, workResult);
                System.out.println(workResult);
                return workResult;
            }).collect(Collectors.toList());
            System.out.println("end-" + SystemClock.now());
            System.err.println("cost-" + (SystemClock.now() - now));

            String responseMetadata = "{\"$code\":{\"type\":\"int\",\"path\":\"getArticles#code\"},\"$message\":{\"type\":\"String\",\"path\":\"getArticles#message\"},\"$data\":{\"$articleResp\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\",\"limit\",\"list\"],\"$articleResp3\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\"]},\"$myName\":{\"type\":\"int\",\"path\":\"getArticles#code\"}},\"$articleResp2\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\"]}}}";
            return formatResult(responseMetadata, workResultMap);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

    private List<WorkerWrapper<HttpRequest, JSONObject>> a(List<HttpRequest> httpRequests, List<HttpRequest> allHttpRequests,  Map<String, WorkerWrapper> workerWrapperStringMap2) {
        // 创建Ref为空的，优先执行
        List<WorkerWrapper<HttpRequest, JSONObject>> list = httpRequests.stream().map(req -> {
            List<HttpRequest> refList = allHttpRequests.stream().filter(h -> req.getName().equals(h.getRef())).collect(Collectors.toList());
            HttpWorker httpWorker = new HttpWorker();
            if (CollectionUtils.isEmpty(refList)) {
                WorkerWrapper<HttpRequest, JSONObject> build = new WorkerWrapper.Builder<HttpRequest, JSONObject>()
                        .worker(httpWorker)
                        .param(req)
                        .build();
                workerWrapperStringMap2.put(req.getName(), build);
                return build;
            } else {
                List<WorkerWrapper<HttpRequest, JSONObject>> workerWrappers = a(refList, allHttpRequests, workerWrapperStringMap2);
                WorkerWrapper<HttpRequest, JSONObject> build = new WorkerWrapper.Builder<HttpRequest, JSONObject>()
                        .worker(httpWorker)
                        .next(workerWrappers.toArray(new WorkerWrapper[workerWrappers.size()]))
                        .param(req)
                        .build();
                workerWrapperStringMap2.put(req.getName(), build);
                return build;
            }

        }).collect(Collectors.toList());

        return list;
    }

    private JSONObject formatResult(String responseMetadata, Map<String, WorkResult<JSONObject>> workResultMap) {
        // 响应格式元数据
        JSONObject responseMetadataJson = JSONObject.parseObject(responseMetadata);
        Set<String> metaDataKeys = responseMetadataJson.keySet();
        JSONObject resultJson = new JSONObject();
        pro(metaDataKeys, responseMetadataJson, workResultMap, resultJson);
        return resultJson;

    }

    private void pro(Set<String> metaDataKeys, JSONObject responseMetadataJson, Map<String, WorkResult<JSONObject>> workResultMap, JSONObject resultJson) {

        for (String metaDataKey : metaDataKeys) {
            JSONObject metadataJson = responseMetadataJson.getJSONObject(metaDataKey);
            if (metadataJson.containsKey("path") && metadataJson.containsKey("type")) {
                String type = metadataJson.getString("type");
                String path = metadataJson.getString("path");

                String[] paths = path.split("#");
                String apiName = paths[0];
                String pathValue = paths[1];
                WorkResult workResult = workResultMap.get(apiName);
                JSONObject workResultResultJson = (JSONObject)workResult.getResult();
                if (type.equals("int")) {
                    Integer value = workResultResultJson.getInteger(pathValue);
                    resultJson.put(formatKey(metaDataKey), value);
                }

                if (type.equals("String")) {
                    Integer value = workResultResultJson.getInteger(pathValue);
                    resultJson.put(formatKey(metaDataKey), value);
                }

                if (type.equals("Entity")) {
                    JSONArray fields = new JSONArray();
                    if (metadataJson.containsKey("fields")) {
                        fields = metadataJson.getJSONArray("fields");
                    }

                    JSONObject newJsonObject = new JSONObject();
                    JSONObject jsonObject = workResultResultJson.getJSONObject(pathValue);
                    Set<String> keySets = jsonObject.keySet();
                    for (String k : keySets) {
                        if (fields.contains(k)) {
                            newJsonObject.put(k, jsonObject.get(k));
                        }
                    }
                    resultJson.put(formatKey(metaDataKey), newJsonObject);

                    Set<String> keySet = metadataJson.keySet();
                    for (String k : keySet) {
                        if (k.startsWith("$")) {
                            Set<String> nk = new HashSet<>();
                            nk.add(k);
                            pro(nk, metadataJson, workResultMap, newJsonObject);
                            resultJson.put(formatKey(metaDataKey), newJsonObject);
                        }
                    }
                }





            } else {
                JSONObject newJsonObject = new JSONObject();
                Set<String> childMetaDataKeys = metadataJson.keySet();
                pro(childMetaDataKeys, metadataJson, workResultMap, newJsonObject);
                resultJson.put(formatKey(metaDataKey), newJsonObject);
            }

        }
    }

    private String formatKey(String key) {
        if (key.startsWith("$")) {
            key = key.replace("$", "").trim();
        }
        return key;
    }
}