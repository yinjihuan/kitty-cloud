package com.cxytiandi.kittycloud.article.api.service;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.article.api.fallback.ArticleRemoteServiceFallbackFactory;
import com.cxytiandi.kittycloud.article.api.request.ArticleQueryRequest;
import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.common.base.PageEntity;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 文章REST/RPC接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@FeignClient(name = "kitty-cloud-comment-provider", fallbackFactory = ArticleRemoteServiceFallbackFactory.class)
public interface ArticleRemoteService {

    /**
     * 文章信息
     * @param articleId 文章ID
     * @return
     */
    @GetMapping("/articles/{articleId}")
    ResponseData<ArticleResponse> getArticle(@PathVariable("articleId") Long articleId);

    /**
     * 热门文章
     * @param request  分页参数
     * @return
     */
    @GetMapping("/articles/hot")
    ResponseData<Page<ArticleResponse>> listHotArticles(@SpringQueryMap ArticleQueryRequest request);

    /**
     * 最新文章
     * @param request  分页参数
     * @return
     */
    @GetMapping("/articles/newest")
    ResponseData<Page<ArticleResponse>> listNewestArticles(@SpringQueryMap ArticleQueryRequest request);

    /**
     * 所有文章
     * @param request  分页参数
     * @return
     */
    @GetMapping("/articles")
    ResponseData<Page<ArticleResponse>> listArticles(@SpringQueryMap ArticleQueryRequest request);

}
