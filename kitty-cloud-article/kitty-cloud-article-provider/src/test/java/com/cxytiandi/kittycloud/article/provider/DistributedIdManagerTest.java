package com.cxytiandi.kittycloud.article.provider;

import com.cxytiandi.kittycloud.article.biz.manager.DistributedIdManager;
import com.cxytiandi.kittycloud.article.biz.manager.UserManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 分布式ID测试
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-06 17:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistributedIdManagerTest {

    @Autowired
    private DistributedIdManager distributedIdManager;

    @Test
    public void testGetDistributedId() {
        String distributedId = distributedIdManager.getDistributedId();
        Assert.assertNotNull(distributedId);
    }
}