package com.cxytiandi.kittycloud.article.provider.service;

import com.cxytiandi.kittycloud.common.base.Page;
import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.article.api.service.ArticleRemoteService;
import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;
import com.cxytiandi.kittycloud.article.biz.service.ArticleService;
import com.cxytiandi.kittycloud.article.provider.convert.ArticleResponseConvert;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章REST/RPC实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@Service(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP)
@RestController
public class ArticleRemoteServiceImpl implements ArticleRemoteService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleResponseConvert articleResponseConvert;

    @Override
    public ResponseData<ArticleResponse> getArticle(Long articleId) {
        ArticleBO article = articleService.getArticle(articleId);
        return Response.ok(articleResponseConvert.convert(article));
    }

    @Override
    public ResponseData<com.cxytiandi.kittycloud.common.base.Page<ArticleResponse>> listHotArticles(int page, int pageSize) {
        Page<ArticleBO> articlesPage = articleService.listHotArticles(page, pageSize);

        List<ArticleResponse> articleResponses = articlesPage.getList().stream().map(articleResponseConvert::convert).collect(Collectors.toList());
        Page pageResponse = new Page(page, pageSize, articleResponses, articlesPage.getTotalRecords());

        return Response.ok(pageResponse);
    }

    @Override
    public ResponseData<Page<ArticleResponse>> listNewestArticles(int page, int pageSize) {
        Page<ArticleBO> articlesPage = articleService.listNewestArticles(page, pageSize);

        List<ArticleResponse> articleResponses = articlesPage.getList().stream().map(articleResponseConvert::convert).collect(Collectors.toList());
        Page pageResponse = new Page(page, pageSize, articleResponses, articlesPage.getTotalRecords());

        return Response.ok(pageResponse);
    }

}