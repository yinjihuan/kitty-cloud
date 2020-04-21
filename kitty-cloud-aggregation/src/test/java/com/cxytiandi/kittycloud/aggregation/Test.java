package com.cxytiandi.kittycloud.aggregation;

import com.alibaba.fastjson.JSONObject;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import com.cxytiandi.kittycloud.aggregation.worker.HttpWorker;
import com.jd.platform.async.executor.Async;
import com.jd.platform.async.executor.timer.SystemClock;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 22:07
 */
public class Test {
    public static void main(String[] args) {
        List<HttpWorker> httpWorkers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            HttpWorker httpWorker = new HttpWorker();
            httpWorkers.add(httpWorker);
        }

        List<WorkerWrapper> workerWrappers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            HttpWorker httpWorker = httpWorkers.get(i);
            WorkerWrapper<HttpRequest, JSONObject> workerWrapper =  new WorkerWrapper.Builder<HttpRequest, JSONObject>()
                    .worker(httpWorker)
                    .build();
            workerWrappers.add(workerWrapper);
        }
        long now = SystemClock.now();
        System.out.println("begin-" + now);
        try {
            Async.beginWork(1500, workerWrappers.toArray(new WorkerWrapper[workerWrappers.size()]));
            for (int i = 0; i < 3; i++) {
                WorkResult workResult = workerWrappers.get(i).getWorkResult();
                System.out.println(workResult);
            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end-" + SystemClock.now());
        System.err.println("cost-" + (SystemClock.now() - now));
        Async.shutDown();
    }
}