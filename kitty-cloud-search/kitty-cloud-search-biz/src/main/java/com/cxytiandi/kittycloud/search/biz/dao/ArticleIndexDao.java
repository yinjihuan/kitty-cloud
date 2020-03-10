package com.cxytiandi.kittycloud.search.biz.dao;

import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 22:48
 */
public interface ArticleIndexDao {

    /**
     * 保存文章索引
     * @param document
     * @return
     */
    Boolean saveArticleIndex(ArticleDocument document);

}
