package com.cxytiandi.kittycloud.article.biz.manager.impl;

import com.alicp.jetcache.anno.Cached;
import com.cxytiandi.kittycloud.article.biz.manager.ArticleManager;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ArticleManagerImpl implements ArticleManager {

    // @Reference dubbo调用， @Autowired Feign调用
    @Autowired
    // @Reference(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP)
    private UserRemoteService userRemoteService;

    @Cached(name = "ArticleManagerImpl:getNickname:", key = "#userId", expire = 1, timeUnit = TimeUnit.DAYS)
    @Override
    public String getNickname(Long userId) {
        ResponseData<UserResponse> user = userRemoteService.getUser(userId);
        return user.isSuccess() ? user.getData().getNickname() : "";
    }

}