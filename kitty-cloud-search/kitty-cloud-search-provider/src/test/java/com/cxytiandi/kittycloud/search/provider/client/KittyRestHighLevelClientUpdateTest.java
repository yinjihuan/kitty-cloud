package com.cxytiandi.kittycloud.search.provider.client;

import com.cxytiandi.kitty.common.json.JsonUtils;
import com.cxytiandi.kitty.db.elasticsearch.client.KittyRestHighLevelClient;
import com.cxytiandi.kittycloud.common.constant.EsConstant;
import com.cxytiandi.kittycloud.search.biz.config.ElasticSearchIndexConfig;
import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;
import com.google.common.collect.Lists;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.HashMap;
import java.util.Map;

/**
 * KittyRestHighLevelClient Update 单测
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-26 23:48
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KittyRestHighLevelClientUpdateTest {

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
        articleDocument.setTextContent("我要学Java好不好");
        articleDocument.setTitle("Java怎么学啊");
        articleDocument.setType(1);
        articleDocument.setUserId(1L);
        return articleDocument;
    }

    @Test
    public void testUpdate() {
        ArticleDocument articleDocument = buildArticleDocument();
        UpdateResponse updateResponse = kittyRestHighLevelClient.update(elasticSearchIndexConfig.getArticleSaveIndexName(), EsConstant.DEFAULT_TYPE, articleDocument.getId().toString(), articleDocument);
        Assert.assertTrue(updateResponse.getResult() == DocWriteResponse.Result.UPDATED);
    }

    @Test
    public void testUpdate2() {
        String id = "1";
        Map<String, Object> articleDocument = new HashMap<>();
        articleDocument.put("title", "Java怎么学啊,666");
        UpdateResponse updateResponse = kittyRestHighLevelClient.update(elasticSearchIndexConfig.getArticleSaveIndexName(), EsConstant.DEFAULT_TYPE, id, articleDocument);
        Assert.assertTrue(updateResponse.getResult() == DocWriteResponse.Result.UPDATED);
    }

    @Test
    public void testUpdate3() {
        ArticleDocument articleDocument = buildArticleDocument();
        UpdateRequest updateRequest = new UpdateRequest(elasticSearchIndexConfig.getArticleSaveIndexName(), EsConstant.DEFAULT_TYPE, articleDocument.getId().toString());
        updateRequest.doc(JsonUtils.toJson(articleDocument), XContentType.JSON);

        UpdateResponse updateResponse = kittyRestHighLevelClient.update(updateRequest);
        Assert.assertTrue(updateResponse.getResult() == DocWriteResponse.Result.UPDATED);
    }

}
