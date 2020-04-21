package com.cxytiandi.kittycloud.aggregation;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cxytiandi.kitty.common.json.JsonUtils;
import com.cxytiandi.kittycloud.aggregation.metadata.ApiMetadataService;
import com.cxytiandi.kittycloud.aggregation.request.HttpAggregationRequest;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import com.cxytiandi.kittycloud.aggregation.worker.HttpWorker;
import com.jd.platform.async.executor.Async;
import com.jd.platform.async.executor.timer.SystemClock;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    private ApiMetadataService apiMetadataService;

    public Object apiAggregator(String api) {
        HttpAggregationRequest httpAggregationRequest = apiMetadataService.getHttpAggregationRequest(api);
        List<HttpRequest> httpRequests = httpAggregationRequest.getHttpRequests();
        Map<String, WorkResult<JSONObject>> workResultMap = new HashMap<>();
        Map<WorkerWrapper, String> workerWrapperStringMap = new HashMap<>();

        List<WorkerWrapper> workerWrappers = httpRequests.stream().map(httpRequest -> {
            HttpWorker httpWorker = new HttpWorker();
            WorkerWrapper<HttpRequest, JSONObject> build = new WorkerWrapper.Builder<HttpRequest, JSONObject>()
                    .worker(httpWorker)
                    .param(httpRequest)
                    .build();
            workerWrapperStringMap.put(build, httpRequest.getName());
            return  build;
        }).collect(Collectors.toList());

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

            JSONObject result = new JSONObject();
            String responseMetadata = "{\"$code\":{\"type\":\"int\",\"path\":\"getArticles#code\"},\"$message\":{\"type\":\"String\",\"path\":\"getArticles#message\"},\"$data\":{\"$articleResp\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\",\"limit\",\"list\"],\"$articleResp3\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\"]},\"$myName\":{\"type\":\"int\",\"path\":\"getArticles#code\"}},\"$articleResp2\":{\"type\":\"Entity\",\"path\":\"getArticles#data\",\"fields\":[\"start\"]}}}";
            return formatResult(responseMetadata, workResultMap);

        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "";
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