package com.cxytiandi.kittycloud.search.provider.client;

import com.cxytiandi.kitty.common.json.JsonUtils;
import com.cxytiandi.kitty.db.elasticsearch.client.KittyRestHighLevelClient;
import com.cxytiandi.kittycloud.common.constant.EsConstant;
import com.cxytiandi.kittycloud.search.biz.config.ElasticSearchIndexConfig;
import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;
import com.google.common.collect.Lists;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

/**
 * KittyRestHighLevelClient Index 单测
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-26 23:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KittyRestHighLevelClientIndexTest {

    @Autowired
    private KittyRestHighLevelClient kittyRestHighLevelClient;

    @Autowired
    private ElasticSearchIndexConfig elasticSearchIndexConfig;

    private ArticleDocument buildArticleDocument() {
        ArticleDocument articleDocument = new ArticleDocument();
        articleDocument.setId(1L);
        articleDocument.setHeat(100);
        articleDocument.setStatus(1);
        articleDocument.setTags(Lists.newArrayList("java"));
        articleDocument.setTextContent("我要学Java");
        articleDocument.setTitle("Java怎么学");
        articleDocument.setType(1);
        articleDocument.setUserId(1L);
        return articleDocument;
    }

    @Test
    public void testIndex() {
        ArticleDocument articleDocument = buildArticleDocument();
        IndexResponse indexResponse = kittyRestHighLevelClient.index(elasticSearchIndexConfig.getArticleSaveIndexName(), EsConstant.DEFAULT_TYPE, articleDocument);
        Assert.assertTrue(StringUtils.hasText(indexResponse.getId()));
    }

    @Test
    public void testIndex2() {
        ArticleDocument articleDocument = buildArticleDocument();
        IndexResponse indexResponse = kittyRestHighLevelClient.index(elasticSearchIndexConfig.getArticleSaveIndexName(), EsConstant.DEFAULT_TYPE, articleDocument, articleDocument.getId().toString());
        Assert.assertTrue(StringUtils.hasText(indexResponse.getId()));
    }

    @Test
    public void testIndex3() {
        ArticleDocument articleDocument = buildArticleDocument();
        IndexRequest indexRequest = new IndexRequest();
        indexRequest.id(articleDocument.getId().toString());
        indexRequest.type(EsConstant.DEFAULT_TYPE);
        indexRequest.index(elasticSearchIndexConfig.getArticleSaveIndexName());
        indexRequest.source(JsonUtils.toJson(articleDocument), XContentType.JSON);

        IndexResponse indexResponse = kittyRestHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        Assert.assertTrue(StringUtils.hasText(indexResponse.getId()));
    }

}
