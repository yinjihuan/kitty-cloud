package com.cxytiandi.kittycloud.search.provider.service;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSearchRequest;
import com.cxytiandi.kittycloud.search.api.response.ArticleIndexResponse;
import com.cxytiandi.kittycloud.search.api.service.ArticleIndexRemoteService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-23 22:38
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleIndexRemoteServiceTest {

    @Autowired
    private ArticleIndexRemoteService articleIndexRemoteService;

    @Test
    public void testSaveArticleIndex() {
        ArticleIndexSaveRequest request = new ArticleIndexSaveRequest();
        request.setId(1L);
        request.setUserId(1L);
        request.setHeat(100);
        request.setStatus(1);
        request.setTitle("测试文章");
        request.setTags("java,spring");
        request.setTextContent("从入门到放弃");
        ResponseData<Boolean> saveArticleIndexResp = articleIndexRemoteService.saveArticleIndex(request);
        Assert.assertTrue(saveArticleIndexResp.isSuccess());
    }

    @Test
    public void testSearchArticleIndex() {
        ArticleIndexSearchRequest request = new ArticleIndexSearchRequest();
        request.setPage(1);
        request.setPageSize(10);
        ResponseData<Page<ArticleIndexResponse>> searchArticleIndexResp = articleIndexRemoteService.searchArticleIndex(request);
        Assert.assertTrue(searchArticleIndexResp.isSuccess());
    }

}