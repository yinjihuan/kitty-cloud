package com.cxytiandi.kittycloud.search.provider.client;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kitty.db.elasticsearch.client.KittyRestHighLevelClient;
import com.cxytiandi.kittycloud.common.constant.EsConstant;
import com.cxytiandi.kittycloud.search.biz.config.ElasticSearchIndexConfig;
import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.common.lucene.search.function.CombineFunction;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.script.Script;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * KittyRestHighLevelClient Search 单测
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-26 23:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class KittyRestHighLevelClientSearchTest {

    @Autowired
    private KittyRestHighLevelClient kittyRestHighLevelClient;

    @Autowired
    private ElasticSearchIndexConfig elasticSearchIndexConfig;

    @Test
    public void testSearchByPage() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.termQuery("type", 1));
        searchSourceBuilder.query(boolQuery).from(0).size(10);

        SearchRequest searchRequest = new SearchRequest(elasticSearchIndexConfig.getArticleSearchIndexName());
        searchRequest.types(EsConstant.DEFAULT_TYPE);
        searchRequest.source(searchSourceBuilder);

        Page<ArticleDocument> searchResult = kittyRestHighLevelClient.searchByPage(searchRequest, ArticleDocument.class);
        Assert.assertTrue(searchResult.getTotalPages() > 0);
    }

    @Test
    public void testSearchByPage2() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        searchSourceBuilder.query(boolQuery);

        SearchRequest searchRequest = new SearchRequest(elasticSearchIndexConfig.getArticleSearchIndexName());
        searchRequest.types(EsConstant.DEFAULT_TYPE);
        searchRequest.source(searchSourceBuilder);

        Page<ArticleDocument> searchResult = kittyRestHighLevelClient.searchByPage(1, 10, searchRequest, ArticleDocument.class);
        Assert.assertTrue(searchResult.getTotalPages() > 0);
    }

    @Test
    public void testSearch() {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.termQuery("type", 1));
        searchSourceBuilder.query(boolQuery);

        SearchRequest searchRequest = new SearchRequest(elasticSearchIndexConfig.getArticleSearchIndexName());
        searchRequest.types(EsConstant.DEFAULT_TYPE);
        searchRequest.source(searchSourceBuilder);

        List<ArticleDocument> searchResults = kittyRestHighLevelClient.search(searchRequest, ArticleDocument.class);
        Assert.assertTrue(!CollectionUtils.isEmpty(searchResults));
    }

    @Test
    public void testSort() {
        String scoreScript = "if (doc['type'].value == 3) {" +
                "   return 100;" +
                "} else {" +
                "   return 1;" +
                "}";

        FunctionScoreQueryBuilder.FilterFunctionBuilder[] filterFunctionBuilders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[]{
                new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchAllQuery(), ScoreFunctionBuilders.scriptFunction(new Script(scoreScript)))
        };

        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        boolQuery.must(QueryBuilders.termQuery("userId", 1));

        FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(boolQuery, filterFunctionBuilders);
        searchSourceBuilder.query(functionScoreQueryBuilder)
                .sort("_score", SortOrder.DESC)
                .sort("heat", SortOrder.DESC);

        SearchRequest searchRequest = new SearchRequest(elasticSearchIndexConfig.getArticleSearchIndexName());
        searchRequest.types(EsConstant.DEFAULT_TYPE);
        searchRequest.source(searchSourceBuilder);


        List<ArticleDocument> searchResults = kittyRestHighLevelClient.search(searchRequest, ArticleDocument.class);
        searchResults.forEach(doc -> {
            System.out.println(doc.getId() + "\t" + doc.getType() + "\t" + doc.getHeat());
        });
    }
}
