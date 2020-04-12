package com.cxytiandi.kittycloud.article.provider;

import com.cxytiandi.kittycloud.article.biz.filter.FilterProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 文章Service测试
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-31 21:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private FilterProcessor filterProcessor;

    @Test
    public void testSensitiveWordFilters() {
        filterProcessor.runSensitiveWordFilters("你是一个逗比吗?");
    }

}