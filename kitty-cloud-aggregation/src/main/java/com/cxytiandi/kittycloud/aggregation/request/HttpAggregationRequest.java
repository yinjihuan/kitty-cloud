package com.cxytiandi.kittycloud.aggregation.request;

import lombok.Data;

import java.util.List;

/**
 * Http 请求参数信息聚合
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 22:00
 */
@Data
public class HttpAggregationRequest {

    /**
     * Http 请求参数信息
     */
    private List<HttpRequest> httpRequests;

}