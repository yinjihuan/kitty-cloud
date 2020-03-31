package com.cxytiandi.kittycloud.article.biz.filter;

import lombok.Data;

/**
 * 敏感词过滤结果
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-30 23:02
 */
@Data
public class SensitiveWordFilterResult {

    /**
     * 是否命中敏感词
     */
    private boolean success;

    /**
     * 提示信息
     */
    private String message;

}