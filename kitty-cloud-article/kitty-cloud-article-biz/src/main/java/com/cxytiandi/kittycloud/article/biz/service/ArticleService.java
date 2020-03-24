package com.cxytiandi.kittycloud.article.biz.service;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;

/**
 * 文章业务接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
public interface ArticleService {

    /**
     * 文章信息
     * @param articleId 文章ID
     * @return
     */
    ArticleBO getArticle(Long articleId);

    /**
     * 热门文章
     * @param page  页数
     * @param pageSize 页大小
     * @return
     */
    Page<ArticleBO> listHotArticles(int page, int pageSize);

    /**
     * 最新文章
     * @param page  页数
     * @param pageSize  页大小
     * @return
     */
    Page<ArticleBO> listNewestArticles(int page, int pageSize);

}
