package com.cxytiandi.kittycloud.article.api.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.common.base.ResponseData;
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
public interface ArticleRemoteService {

    /**
     * 文章信息
     * @param articleId 文章ID
     * @return
     */
    @GetMapping("/articles/{articleId}")
    ResponseData<ArticleResponse> getArticle(@PathVariable Long articleId);

    /**
     * 热门文章
     * @param page  页数
     * @param pageSize 页大小
     * @return
     */
    @GetMapping("/articles/hot")
    ResponseData<IPage<ArticleResponse>> listHotArticles(int page, int pageSize);

    /**
     * 最新文章
     * @param page  页数
     * @param pageSize  页大小
     * @return
     */
    @GetMapping("/articles/newest")
    ResponseData<IPage<ArticleResponse>> listNewestArticles(int page, int pageSize);

}
