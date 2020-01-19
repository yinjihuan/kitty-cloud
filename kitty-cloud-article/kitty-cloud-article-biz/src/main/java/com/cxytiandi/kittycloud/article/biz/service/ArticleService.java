package com.cxytiandi.kittycloud.article.biz.service;

import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;
import java.util.List;


/**
 * 文章业务接口
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
public interface ArticleService {

    /**
     * 文章信息
     * @param articleId 文章ID
     * @return
     */
    ArticleBO getArticle(int articleId);

    /**
     * 热门文章
     * @param page  页数
     * @param pageSize 页大小
     * @return
     */
    List<ArticleBO> listHotArticles(int page, int pageSize);

    /**
     * 最新文章
     * @param page  页数
     * @param pageSize  页大小
     * @return
     */
    List<ArticleBO> listNewestArticles(int page, int pageSize);

}
