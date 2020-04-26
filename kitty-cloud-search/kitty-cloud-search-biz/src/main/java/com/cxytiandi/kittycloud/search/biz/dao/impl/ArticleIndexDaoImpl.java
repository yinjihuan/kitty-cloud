package com.cxytiandi.kittycloud.search.biz.dao.impl;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kitty.db.elasticsearch.client.KittyRestHighLevelClient;
import com.cxytiandi.kittycloud.common.constant.CommonConstant;
import com.cxytiandi.kittycloud.common.constant.EsConstant;
import com.cxytiandi.kittycloud.search.biz.bo.ArticleIndexBO;
import com.cxytiandi.kittycloud.search.biz.config.ElasticSearchIndexConfig;
import com.cxytiandi.kittycloud.search.biz.dao.ArticleIndexDao;
import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;
import com.cxytiandi.kittycloud.search.biz.param.ArticleIndexSearchParam;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

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

    @Override
    public Page<ArticleDocument> searchArticleIndex(ArticleIndexSearchParam param) {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(buildSearchArticleIndexQuery(param))
                .from(Page.page2Start(param.getPage(), param.getSize()))
                .size(param.getSize());

        SearchRequest searchRequest = new SearchRequest(elasticSearchIndexConfig.getArticleSearchIndexName());
        searchRequest.types(EsConstant.DEFAULT_TYPE);
        searchRequest.source(searchSourceBuilder);
        return restHighLevelClient.searchByPage(searchRequest, ArticleDocument.class);
    }

    private BoolQueryBuilder buildSearchArticleIndexQuery(ArticleIndexSearchParam param) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();

        if (param.getType() > CommonConstant.ZERO_NUM) {
            boolQuery.must(QueryBuilders.termQuery("type", param.getType()));
        }

        if (StringUtils.hasText(param.getTag())) {
            boolQuery.must(QueryBuilders.termQuery("tag", param.getTag()));
        }

        if (StringUtils.hasText(param.getKeyword())) {
            boolQuery.must(
                    QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("title", param.getKeyword()))
                            .should(QueryBuilders.matchQuery("textContent", param.getKeyword()))
            );
        }

        return boolQuery;
    }
}