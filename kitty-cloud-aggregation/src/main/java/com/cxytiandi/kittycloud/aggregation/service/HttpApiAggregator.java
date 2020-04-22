package com.cxytiandi.kittycloud.aggregation.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cxytiandi.kittycloud.aggregation.constant.AggregationConstant;
import com.cxytiandi.kittycloud.aggregation.request.HttpAggregationRequest;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import com.cxytiandi.kittycloud.aggregation.worker.HttpWorker;
import com.jd.platform.async.executor.Async;
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
        // 获取API 元数据
        HttpAggregationRequest httpAggregationRequest = apiMetaDataService.getHttpAggregationRequest(apiName);
        List<HttpRequest> httpRequests = httpAggregationRequest.getHttpRequests();

        //  构建API请求参数
        buildApiRequest(request, httpRequests);

        // API对应的执行结果映射
        Map<String, WorkResult<JSONObject>> apiWorkResultMapping = new HashMap<>();

        // API对应的WorkerWrapper映射
        Map<String, WorkerWrapper> apiWorkerWrapperMapping = new HashMap<>();

        // WorkerWrapper对应的API映射
        Map<WorkerWrapper, String> workerWrapperApiMapping = new HashMap<>();

        // Ref为空的，优先执行
        List<HttpRequest> highLevelRequests = httpRequests.stream().filter(hr -> StringUtils.isEmpty(hr.getRef())).collect(Collectors.toList());

        // 构建WorkerWrapper
        List<WorkerWrapper<HttpRequest, JSONObject>> workerWrappers = buildWorkerWrapper(highLevelRequests, httpRequests, apiWorkerWrapperMapping);

        // 设置Worker参数，有的Worker参数依赖于上一个Worker的结果
        setApiWorkerWrapperParam(httpRequests, apiWorkerWrapperMapping);

        try {
            Async.beginWork(100000, workerWrappers.toArray(new WorkerWrapper[workerWrappers.size()]));
            workerWrappers.stream().forEach(wrapper -> {
                WorkResult<JSONObject> workResult = wrapper.getWorkResult();
                String api = workerWrapperApiMapping.get(wrapper);
                apiWorkResultMapping.put(api, workResult);
            });

            String responseMetadata = "{\"$code\":{\"type\":\"int\",\"path\":\"getArticles#code\"},\"$message\":{\"type\":\"String\",\"path\":\"getArticles#message\"},\"$data\":{\"$articleResp\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\",\"limit\",\"list\"],\"$articleResp3\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\"]},\"$myName\":{\"type\":\"int\",\"path\":\"getArticles#code\"}},\"$articleResp2\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\"]}}}";
            return formatResult(responseMetadata, apiWorkResultMapping);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * 构建API请求参数
     * @param request
     * @param httpRequests
     */
    private void buildApiRequest(HttpServletRequest request, List<HttpRequest> httpRequests) {
        httpRequests.forEach( req -> {
            Map paramsMap = new HashMap<>();
            String params = req.getParams();
            if (StringUtils.hasText(params)) {
                paramsMap = JSONObject.parseObject(params, Map.class);
            }
            Set<String> paramKeys = paramsMap.keySet();
            for(String key : paramKeys) {
                Object value = paramsMap.get(key);
                if (value.toString().startsWith(AggregationConstant.REQUEST)) {
                    String param = value.toString().split("\\.")[1];
                    String parameter = request.getParameter(param);
                    paramsMap.put(key, parameter);
                }
            }
            req.setParamsValueMap(paramsMap);
        });
    }

    /**
     * 构建WorkerWrapper
     * @param highLevelRequests
     * @param allHttpRequests
     * @param workerWrapperStringMap2
     * @return
     */
    private List<WorkerWrapper<HttpRequest, JSONObject>> buildWorkerWrapper(List<HttpRequest> highLevelRequests, List<HttpRequest> allHttpRequests,  Map<String, WorkerWrapper> workerWrapperStringMap2) {
        List<WorkerWrapper<HttpRequest, JSONObject>> list = highLevelRequests.stream().map(req -> {
            List<HttpRequest> refHttpRequests = allHttpRequests.stream().filter(h -> req.getName().equals(h.getRef())).collect(Collectors.toList());
            HttpWorker httpWorker = new HttpWorker();
            if (CollectionUtils.isEmpty(refHttpRequests)) {
                WorkerWrapper<HttpRequest, JSONObject> build = new WorkerWrapper.Builder<HttpRequest, JSONObject>()
                        .worker(httpWorker)
                        .param(req)
                        .build();
                workerWrapperStringMap2.put(req.getName(), build);
                return build;
            } else {
                List<WorkerWrapper<HttpRequest, JSONObject>> workerWrappers = buildWorkerWrapper(refHttpRequests, allHttpRequests, workerWrapperStringMap2);
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

    /**
     * 设置Worker参数，有的Worker参数依赖于上一个Worker的结果
     * @param httpRequests
     * @param apiWorkerWrapperMapping
     */
    private void setApiWorkerWrapperParam(List<HttpRequest> httpRequests, Map<String, WorkerWrapper> apiWorkerWrapperMapping) {
        for (HttpRequest httpRequest : httpRequests) {
            WorkerWrapper<HttpRequest, JSONObject> apiWorkerWrapper = apiWorkerWrapperMapping.get(httpRequest.getName());

            WorkerWrapper<HttpRequest, JSONObject> apiRefWorkerWrapper = apiWorkerWrapperMapping.get(httpRequest.getRef());
            if (apiRefWorkerWrapper != null) {
                httpRequest.setWorkResult(apiRefWorkerWrapper.getWorkResult());
            }

            apiWorkerWrapper.setParam(httpRequest);
        }
    }

    /**
     * 格式化结果
     * @param responseMetadata
     * @param apiWorkResultMapping
     * @return
     */
    private JSONObject formatResult(String responseMetadata, Map<String, WorkResult<JSONObject>> apiWorkResultMapping) {
        // 响应格式元数据
        JSONObject responseMetadataJson = JSONObject.parseObject(responseMetadata);
        Set<String> metaDataKeys = responseMetadataJson.keySet();
        JSONObject resultJson = new JSONObject();
        doFormatResult(metaDataKeys, responseMetadataJson, apiWorkResultMapping, resultJson);
        return resultJson;

    }

    private void doFormatResult(Set<String> metaDataKeys, JSONObject responseMetadataJson, Map<String, WorkResult<JSONObject>> workResultMap, JSONObject resultJson) {

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
                    resultJson.put(formatMetaDataKey(metaDataKey), value);
                }

                if (type.equals("String")) {
                    Integer value = workResultResultJson.getInteger(pathValue);
                    resultJson.put(formatMetaDataKey(metaDataKey), value);
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
                    resultJson.put(formatMetaDataKey(metaDataKey), newJsonObject);

                    Set<String> keySet = metadataJson.keySet();
                    for (String k : keySet) {
                        if (k.startsWith("$")) {
                            Set<String> nk = new HashSet<>();
                            nk.add(k);
                            doFormatResult(nk, metadataJson, workResultMap, newJsonObject);
                            resultJson.put(formatMetaDataKey(metaDataKey), newJsonObject);
                        }
                    }
                }





            } else {
                JSONObject newJsonObject = new JSONObject();
                Set<String> childMetaDataKeys = metadataJson.keySet();
                doFormatResult(childMetaDataKeys, metadataJson, workResultMap, newJsonObject);
                resultJson.put(formatMetaDataKey(metaDataKey), newJsonObject);
            }

        }
    }

    /**
     * 格式化元数据Key
     * @param key
     * @return
     */
    private String formatMetaDataKey(String key) {
        if (key.startsWith(AggregationConstant.CURRENCY_SYMBOL)) {
            key = key.replace(AggregationConstant.CURRENCY_SYMBOL, AggregationConstant.DEFAULT_EMPTY_STR).trim();
        }
        return key;
    }
}