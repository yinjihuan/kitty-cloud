package com.cxytiandi.kittycloud.aggregation.request;

import com.alibaba.fastjson.JSONObject;
import com.jd.platform.async.worker.WorkResult;
import lombok.Data;
import java.util.Map;

/**
 * Http 请求参数信息
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 22:00
 */
@Data
public class HttpRequest {

    /**
     * 请求接口名称
     */
    private String name;

    /**
     * 请求的URI
     */
    private String uri;

    /**
     * 调用类型（服务发现：discover，直连：direct）
     */
    private String callType;

    /**
     * 请求类型
     * @see org.springframework.http.HttpMethod
     */
    private String method;

    /**
     * 参数定义（Json格式）
     */
    private String params;

    /**
     * 接口依赖于哪个接口（名称）
     */
    private String ref;

    /**
     * 任务执行的结果，比如某接口的调用依赖上次的结果
     */
    private WorkResult<JSONObject> workResult;

    /**
     * 参数值，从HttpServletRequest中获取的在这里
     */
    private Map paramsValueMap;

}