package com.cxytiandi.kittycloud.job.service;

import com.cxytiandi.kittycloud.job.param.EsIndexBuildParam;
import com.cxytiandi.kittycloud.job.template.AbstractEsIndexBuildTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 文章索引构建
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-26 22:59
 */
@Service
public class ArticleEsIndexBuildService extends AbstractEsIndexBuildTemplate<EsIndexBuildParam, Boolean> {

    @Override
    protected List getIndexSource(int page, EsIndexBuildParam param) {
        List<String> list = new ArrayList<>();
        list.add("xxxxx");
        return list;
    }

    @Override
    protected void buildIndex(List<Boolean> booleans) {

    }

}