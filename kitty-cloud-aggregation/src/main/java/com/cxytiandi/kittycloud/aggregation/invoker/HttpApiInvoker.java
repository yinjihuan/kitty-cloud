package com.cxytiandi.kittycloud.aggregation.invoker;

import com.alibaba.fastjson.JSONObject;
import com.cxytiandi.kittycloud.aggregation.request.HttpRequest;

import java.util.Map;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-14 23:05
 */
public interface HttpApiInvoker {

    JSONObject invoke(HttpRequest httpRequest);

}