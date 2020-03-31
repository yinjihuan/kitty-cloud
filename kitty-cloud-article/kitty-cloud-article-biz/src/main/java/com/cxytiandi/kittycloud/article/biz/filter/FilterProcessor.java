package com.cxytiandi.kittycloud.article.biz.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 负责执行过滤器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-30 23:08
 */
@Component
public class FilterProcessor {

    @Autowired
    private List<SensitiveWordFilter> sensitiveWordFilters;

    public SensitiveWordFilterResult runSensitiveWordFilters(String content) {
        List<SensitiveWordFilter> filters = sensitiveWordFilters.stream().filter(f -> f.shouldFilter()).sorted(SensitiveWordFilter::compareTo).collect(Collectors.toList());
        for (SensitiveWordFilter filter : filters) {
            SensitiveWordFilterResult filterResult = filter.runFilter(content);
            if (filterResult != null && filterResult.isSuccess()) {
                return filterResult;
            }
        }

        SensitiveWordFilterResult result = new SensitiveWordFilterResult();
        result.setSuccess(false);
        return result;
    }

}