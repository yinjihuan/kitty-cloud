package com.cxytiandi.kittycloud.job.param;

import lombok.Builder;
import lombok.Data;

/**
 * ES索引构建参数
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-26 23:01
 */
@Data
@Builder
public class EsIndexBuildParam {

    /**
     * 任务调度参数
     */
    private String param;

    /**
     * 分页大小
     */
    private int size;

}