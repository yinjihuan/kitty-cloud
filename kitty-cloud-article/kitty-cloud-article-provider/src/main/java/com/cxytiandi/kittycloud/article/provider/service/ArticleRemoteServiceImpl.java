package com.cxytiandi.kittycloud.article.provider.service;

import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.article.api.service.ArticleRemoteService;
import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;
import com.cxytiandi.kittycloud.article.biz.service.ArticleService;
import com.cxytiandi.kittycloud.article.provider.convert.ArticleResponseConvert;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 文章REST/RPC接口实现
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
@RestController
public class ArticleRemoteServiceImpl implements ArticleRemoteService {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleResponseConvert articleResponseConvert;

    @Override
    public ResponseData<ArticleResponse> getArticle(int articleId) {
        ArticleBO article = articleService.getArticle(articleId);
        return Response.ok(articleResponseConvert.convert(article));
    }

    @Override
    public ResponseData<List<ArticleResponse>> listHotArticles(int page, int pageSize) {
        List<ArticleBO> articles = articleService.listHotArticles(page, pageSize);
        List<ArticleResponse> articleResponses = articles.stream().map(articleResponseConvert::convert).collect(Collectors.toList());
        return Response.ok(articleResponses);
    }

    @Override
    public ResponseData<List<ArticleResponse>> listNewestArticles(int page, int pageSize) {
        List<ArticleBO> articles = articleService.listNewestArticles(page, pageSize);
        List<ArticleResponse> articleResponses = articles.stream().map(articleResponseConvert::convert).collect(Collectors.toList());
        return Response.ok(articleResponses);
    }

}