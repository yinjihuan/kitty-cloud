package com.cxytiandi.kittycloud.article.api.service;

import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 文章REST/RPC接口
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
public interface ArticleRemoteService {

    /**
     * 文章信息
     * @param articleId 文章ID
     * @return
     */
    @GetMapping("/articles/{articleId}")
    ResponseData<ArticleResponse> getArticle(@PathVariable int articleId);

    /**
     * 热门文章
     * @param page  页数
     * @param pageSize 页大小
     * @return
     */
    @GetMapping("/articles/hot")
    ResponseData<List<ArticleResponse>> listHotArticles(int page, int pageSize);

    /**
     * 最新文章
     * @param page  页数
     * @param pageSize  页大小
     * @return
     */
    @GetMapping("/articles/newest")
    ResponseData<List<ArticleResponse>> listNewestArticles(int page, int pageSize);

}
