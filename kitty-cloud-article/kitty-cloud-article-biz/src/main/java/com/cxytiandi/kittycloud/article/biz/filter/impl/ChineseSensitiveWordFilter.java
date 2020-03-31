package com.cxytiandi.kittycloud.article.biz.filter.impl;

import com.cxytiandi.kittycloud.article.biz.filter.SensitiveWordFilter;
import com.cxytiandi.kittycloud.article.biz.filter.SensitiveWordFilterResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * 中文敏感词过滤器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-30 23:07
 */
@Component
public class ChineseSensitiveWordFilter extends SensitiveWordFilter {

    /**
     * 敏感词可以维护在数据中或者配置中心里面
     */
    @Value("${kitty.cloud.article.chineseSensitiveWords:逗比,小可爱}")
    private List<String> sensitiveWords;

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public SensitiveWordFilterResult run(String content) {
        SensitiveWordFilterResult result = new SensitiveWordFilterResult();
        Optional<String> sensitiveWordOptional = sensitiveWords.stream().filter(s -> content.contains(s)).findFirst();
        if (!sensitiveWordOptional.isPresent()) {
            result.setSuccess(false);
            return result;
        }

        result.setSuccess(true);
        result.setMessage(sensitiveWordOptional.get() + "命中敏感词");
        return result;
    }

}