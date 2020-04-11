package com.cxytiandi.kittycloud.article.biz.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cxytiandi.kittycloud.article.biz.dataobject.ArticleDO;

/**
 * 文章DAO
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */

public interface ArticleDao {

    /**
     * 获取文章
     * @param id 文章ID
     * @return
     */
    ArticleDO getById(Long id);

    /**
     * 热门文章
     * @param page  页数
     * @param pageSize 页大小
     * @return
     */
    IPage<ArticleDO> listHotArticles(int page, int pageSize);

    /**
     * 最新文章
     * @param page  页数
     * @param pageSize  页大小
     * @return
     */
    IPage<ArticleDO> listNewestArticles(int page, int pageSize);

    /**
     * 所有文章
     * @param page  页数
     * @param pageSize  页大小
     * @return
     */
    IPage<ArticleDO> listArticles(int page, int pageSize);

}
