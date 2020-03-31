package com.cxytiandi.kittycloud.article.biz.filter;

/**
 * 敏感词过滤器接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-30 22:55
 */
public interface ISensitiveWordFilter {

    /**
     * 是否执行过滤器
     * @return
     */
    boolean shouldFilter();

    /**
     * 过滤逻辑
     * @param content 过滤内容
     * @return
     */
    SensitiveWordFilterResult run(String content);
}