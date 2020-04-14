package com.cxytiandi.kittycloud.aggregation;

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

import java.util.List;
import java.util.Map;
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

        List<WorkerWrapper> workerWrappers = httpRequests.stream().map(httpRequest -> {
            HttpWorker httpWorker = new HttpWorker();
             return new WorkerWrapper.Builder<HttpRequest, Map>()
                     .worker(httpWorker)
                     .param(httpRequest)
                     .build();
        }).collect(Collectors.toList());

        long now = SystemClock.now();
        System.out.println("begin-" + now);
        try {
            Async.beginWork(100000, workerWrappers.toArray(new WorkerWrapper[workerWrappers.size()]));
            List<WorkResult> workResults = workerWrappers.stream().map(wrapper -> {
                WorkResult workResult = wrapper.getWorkResult();
                System.out.println(workResult);
                return workResult;
            }).collect(Collectors.toList());
            System.out.println("end-" + SystemClock.now());
            System.err.println("cost-" + (SystemClock.now() - now));
            return workResults;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "";
    }

}