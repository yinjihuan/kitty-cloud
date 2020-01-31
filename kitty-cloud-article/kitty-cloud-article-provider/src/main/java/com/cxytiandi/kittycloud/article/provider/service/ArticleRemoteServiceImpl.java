package com.cxytiandi.kittycloud.article.provider.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    public ResponseData<ArticleResponse> getArticle(Long articleId) {
        ArticleBO article = articleService.getArticle(articleId);
        return Response.ok(articleResponseConvert.convert(article));
    }

    @Override
    public ResponseData<IPage<ArticleResponse>> listHotArticles(int page, int pageSize) {
        Page<ArticleBO> articlesPage = articleService.listHotArticles(page, pageSize);
        Page pageResponse = new Page(page, pageSize, articlesPage.getTotal());
        List<ArticleResponse> articleResponses = articlesPage.getRecords().stream().map(articleResponseConvert::convert).collect(Collectors.toList());
        pageResponse.setRecords(articleResponses);
        return Response.ok(pageResponse);
    }

    @Override
    public ResponseData<IPage<ArticleResponse>> listNewestArticles(int page, int pageSize) {
        Page<ArticleBO> articlesPage = articleService.listNewestArticles(page, pageSize);
        Page pageResponse = new Page(page, pageSize, articlesPage.getTotal());
        List<ArticleResponse> articleResponses = articlesPage.getRecords().stream().map(articleResponseConvert::convert).collect(Collectors.toList());
        pageResponse.setRecords(articleResponses);
        return Response.ok(pageResponse);
    }

}