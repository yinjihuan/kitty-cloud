package com.cxytiandi.kittycloud.article.biz.filter;

/**
 * 敏感词过滤器抽象类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-30 22:55
 */
public abstract class SensitiveWordFilter implements ISensitiveWordFilter, Comparable<SensitiveWordFilter> {

    /**
     * 过滤器执行顺序，数字越小，越先执行
     * @return
     */
    abstract public int filterOrder();

    @Override
    public int compareTo(SensitiveWordFilter filter) {
        return Integer.compare(this.filterOrder(), filter.filterOrder());
    }

    public SensitiveWordFilterResult runFilter(String content) {
        return run(content);
    }

}