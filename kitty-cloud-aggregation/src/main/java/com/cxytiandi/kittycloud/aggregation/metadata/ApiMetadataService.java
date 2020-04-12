package com.cxytiandi.kittycloud.aggregation.metadata;

import com.cxytiandi.kittycloud.aggregation.request.HttpAggregationRequest;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 22:52
 */
public interface ApiMetadataService {

    /**
     * 获取API的聚合请求信息
     * @param api
     * @return
     */
    HttpAggregationRequest getHttpAggregationRequest(String api);

}
