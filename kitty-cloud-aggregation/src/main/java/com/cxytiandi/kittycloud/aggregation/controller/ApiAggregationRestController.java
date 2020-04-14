package com.cxytiandi.kittycloud.aggregation.controller;

import com.cxytiandi.kittycloud.aggregation.HttpApiAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-14 22:58
 */
@RestController
public class ApiAggregationRestController {

    @Autowired
    private HttpApiAggregator httpApiAggregator;

    @GetMapping("/test")
    public Object test() {
        return httpApiAggregator.apiAggregator("");
    }
}