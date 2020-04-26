package com.cxytiandi.kittycloud.search.provider.client;

import com.cxytiandi.kitty.db.elasticsearch.client.KittyRestHighLevelClient;
import com.cxytiandi.kittycloud.common.constant.EsConstant;
import com.cxytiandi.kittycloud.search.biz.config.ElasticSearchIndexConfig;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * KittyRestHighLevelClient Delete 单测
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-26 23:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KittyRestHighLevelClientDeleteTest {

    @Autowired
    private KittyRestHighLevelClient kittyRestHighLevelClient;

    @Autowired
    private ElasticSearchIndexConfig elasticSearchIndexConfig;

    @Test
    public void testDelete() {
        DeleteResponse deleteResponse = kittyRestHighLevelClient.delete(elasticSearchIndexConfig.getArticleSearchIndexName(), EsConstant.DEFAULT_TYPE, "1");
        Assert.assertTrue(deleteResponse.getResult() == DocWriteResponse.Result.DELETED);
    }

    @Test
    public void testDelete2() {
        DeleteRequest deleteRequest = new DeleteRequest(elasticSearchIndexConfig.getArticleSearchIndexName(), EsConstant.DEFAULT_TYPE, "1");
        DeleteResponse deleteResponse = kittyRestHighLevelClient.delete(deleteRequest);
        Assert.assertTrue(deleteResponse.getResult() == DocWriteResponse.Result.DELETED);
    }

}
