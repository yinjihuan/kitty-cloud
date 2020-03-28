package com.cxytiandi.kittycloud.job.service;

//import com.cxytiandi.kitty.common.page.Page;
//import com.cxytiandi.kittycloud.article.api.request.ArticleQueryRequest;
//import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
//import com.cxytiandi.kittycloud.article.api.service.ArticleRemoteService;
//import com.cxytiandi.kittycloud.common.base.PageEntity;
//import com.cxytiandi.kittycloud.common.base.ResponseData;
//import com.cxytiandi.kittycloud.job.convert.ArticleIndexSaveRequestConvert;
//import com.cxytiandi.kittycloud.job.param.EsIndexBuildParam;
//import com.cxytiandi.kittycloud.job.template.AbstractEsIndexBuildTemplate;
//import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
//import com.cxytiandi.kittycloud.search.api.service.ArticleIndexRemoteService;
//import com.google.common.collect.Lists;
import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.article.api.request.ArticleQueryRequest;
import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.article.api.service.ArticleRemoteService;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.job.convert.ArticleIndexSaveRequestConvert;
import com.cxytiandi.kittycloud.job.param.EsIndexBuildParam;
import com.cxytiandi.kittycloud.job.template.AbstractEsIndexBuildTemplate;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
import com.cxytiandi.kittycloud.search.api.service.ArticleIndexRemoteService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
@Slf4j
@Service
public class ArticleEsIndexBuildService extends AbstractEsIndexBuildTemplate<EsIndexBuildParam, ArticleResponse> {

    @Autowired
    private ArticleIndexRemoteService articleIndexRemoteService;

    @Autowired
    private ArticleRemoteService articleRemoteService;

    @Autowired
    private ArticleIndexSaveRequestConvert articleIndexSaveRequestConvert;

    @Override
    protected List<ArticleResponse> getIndexSource(int page, EsIndexBuildParam param) {
        ArticleQueryRequest request = new ArticleQueryRequest();
        request.setPage(page);
        request.setSize(param.getSize());

        ResponseData<Page<ArticleResponse>> articlePageResp = articleRemoteService.listArticles(request);
        if (!articlePageResp.isSuccess()) {
            log.info("文章索引数据源获取为空，page [{}] param [{}] ", page, param);
            return Lists.newArrayList();
        }

        Page<ArticleResponse> articlePage = articlePageResp.getData();
        return articlePage.getList();
    }

    @Override
    protected void buildIndex(ArticleResponse articleResponse) {
        ArticleIndexSaveRequest request = articleIndexSaveRequestConvert.convert(articleResponse);
        ResponseData<Boolean> buildIndexResp = articleIndexRemoteService.saveArticleIndex(request);
        if (!buildIndexResp.isSuccess()) {
            log.error("文章索引构建失败，参数 [{}] ", request);
        }
    }

}