package com.cxytiandi.kittycloud.article.biz.manager.impl;

import com.alicp.jetcache.anno.Cached;
import com.cxytiandi.kitty.id.service.DistributedIdLeafSnowflakeRemoteService;
import com.cxytiandi.kittycloud.article.biz.manager.ArticleManager;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 文章Manager实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@Component
public class ArticleManagerImpl implements ArticleManager {

    @Value("${spring.application.name}")
    private String applicationName;

    // @Reference dubbo调用， @Autowired Feign调用
    @Autowired
    // @Reference(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP)
    private UserRemoteService userRemoteService;

    //@Autowired
    @Reference(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP)
    private DistributedIdLeafSnowflakeRemoteService distributedIdLeafSnowflakeRemoteService;

    //@Cached(name = "ArticleManagerImpl:getNickname:", key = "#userId", expire = 1, timeUnit = TimeUnit.DAYS)
    @Override
    public String getNickname(Long userId) {
        ResponseData<UserResponse> user = userRemoteService.getUser(userId);
        return user.isSuccess() ? user.getData().getNickname() : "";
    }

    @Override
    public String getDistributedId() {
        String snowflakeId = distributedIdLeafSnowflakeRemoteService.getSnowflakeId(applicationName);
        return snowflakeId;
    }

}