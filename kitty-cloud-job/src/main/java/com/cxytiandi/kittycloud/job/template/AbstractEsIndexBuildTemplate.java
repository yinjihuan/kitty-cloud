package com.cxytiandi.kittycloud.job.template;


import com.cxytiandi.kittycloud.job.param.EsIndexBuildParam;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-26 21:43
 */
public abstract class AbstractEsIndexBuildTemplate<Request, Source> {

    public final void execute(Request request) {
        int page = 1;
        boolean hasNext = true;

        while (hasNext) {
            List<Source> sources = getIndexSource(page, request);
            if (!CollectionUtils.isEmpty(sources)) {
                buildIndex(sources);
            } else {
                hasNext = false;
            }
            page++;
        }

    }

    public final void executeWithThreadPool(Request request) {
        int page = 1;
        boolean hasNext = true;

        while (hasNext) {
            List<Source> sources = getIndexSource(page, request);
            if (!CollectionUtils.isEmpty(sources)) {
                buildIndex(sources);
            } else {
                hasNext = false;
            }
            page++;
        }

    }

    protected abstract List getIndexSource(int page, Request request);

    protected abstract void buildIndex(List<Source> sources);

}