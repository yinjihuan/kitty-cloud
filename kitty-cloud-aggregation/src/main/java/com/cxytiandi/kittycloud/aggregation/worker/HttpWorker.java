package com.cxytiandi.kittycloud.aggregation.worker;

import com.cxytiandi.kittycloud.aggregation.request.HttpAggregationRequest;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;
import com.jd.platform.async.callback.IWorker;

import java.util.HashMap;
import java.util.Map;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 21:57
 */
public class HttpWorker implements IWorker<HttpRequest, Map> {

    @Override
    public Map action(HttpRequest httpRequest) {
        System.out.println("xxxxxxx");
        Map<String, Object> map = new HashMap<>();
        map.put("username", "yinjihuan");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public Map defaultValue() {
        return null;
    }
}