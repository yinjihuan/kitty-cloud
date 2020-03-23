package com.cxytiandi.kittycloud.search.biz.dao.impl;

import com.cxytiandi.kitty.db.elasticsearch.client.KittyRestHighLevelClient;
import com.cxytiandi.kittycloud.common.constant.EsConstant;
import com.cxytiandi.kittycloud.search.biz.config.ElasticSearchIndexConfig;
import com.cxytiandi.kittycloud.search.biz.dao.ArticleIndexDao;
import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.rest.RestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 20:50
 */
@Repository
public class ArticleIndexDaoImpl implements ArticleIndexDao {

    @Autowired
    private KittyRestHighLevelClient restHighLevelClient;

    @Autowired
    private ElasticSearchIndexConfig elasticSearchIndexConfig;

    @Override
    public Boolean saveArticleIndex(ArticleDocument document) {
        IndexResponse response = restHighLevelClient.index(elasticSearchIndexConfig.getArticleSaveIndexName(),
                EsConstant.DEFAULT_TYPE, document, document.getId().toString());
        elasticSearchIndexConfig.getArticleSaveIndexName();
        return response.status() == RestStatus.CREATED || response.status() == RestStatus.OK;
    }
}