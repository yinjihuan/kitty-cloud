package com.cxytiandi.kittycloud.article.biz.filter.impl;

import com.cxytiandi.kittycloud.article.biz.filter.SensitiveWordFilter;
import com.cxytiandi.kittycloud.article.biz.filter.SensitiveWordFilterResult;
import org.springframework.stereotype.Component;

/**
 * 英文敏感词过滤器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-30 23:07
 */
@Component
public class EnglishSensitiveWordFilter extends SensitiveWordFilter {

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public SensitiveWordFilterResult run(String content) {
        return null;
    }

}