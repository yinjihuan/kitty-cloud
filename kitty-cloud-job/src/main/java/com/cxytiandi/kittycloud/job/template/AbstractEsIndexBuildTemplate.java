package com.cxytiandi.kittycloud.job.template;


import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * ES索引构建模板
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-26 21:43
 */
public abstract class AbstractEsIndexBuildTemplate<Request, Source> {

    public final void execute(Request request) {
        doExecute(request, false);
    }

    public final void executeWithParallelStream(Request request) {
        doExecute(request, true);
    }

    private void doExecute(Request request, boolean isParalleStream) {
        int page = 1;
        while (true) {
            List<Source> sources = getIndexSource(page, request);

            if (CollectionUtils.isEmpty(sources)) {
                break;
            }

            if (isParalleStream) {
                sources.parallelStream().forEach(this::buildIndex);
            } else {
                sources.stream().forEach(this::buildIndex);
            }

            page++;
        }
    }

    protected abstract List getIndexSource(int page, Request request);

    protected abstract void buildIndex(Source source);

}