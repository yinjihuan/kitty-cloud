package com.cxytiandi.kittycloud.job.handler;

import com.cxytiandi.kittycloud.common.constant.CommonConstant;
import com.cxytiandi.kittycloud.job.param.EsIndexBuildParam;
import com.cxytiandi.kittycloud.job.service.ArticleEsIndexBuildService;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.annotation.XxlJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ES索引构建任务
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-26 23:06
 */
@Component
public class EsIndexBuildHandler {

    @Autowired
    private ArticleEsIndexBuildService articleEsIndexBuildService;

    @XxlJob(value = "ArticleEsIndexBuildHandler")
    public ReturnT<String> execute(String param) {
        EsIndexBuildParam buildParam = EsIndexBuildParam.builder().param(param).size(CommonConstant.DEFAULT_PAGE_SIZE).build();
        articleEsIndexBuildService.execute(buildParam);
        return ReturnT.SUCCESS;
    }

}