package com.cxytiandi.kittycloud.article.biz.manager.impl;

import com.cxytiandi.kittycloud.article.biz.manager.UserManager;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 用户Manager实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@Component
public class UserManagerImpl implements UserManager {

    @Value("${spring.application.name}")
    private String applicationName;

    // @Reference dubbo调用， @Autowired Feign调用
    @Autowired
    // @Reference(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP, check = false)
    private UserRemoteService userRemoteService;

    //@Cached(name = "UserManagerImpl:getNickname:", key = "#userId", expire = 1, timeUnit = TimeUnit.DAYS)
    @Override
    public String getNickname(Long userId) {
        ResponseData<UserResponse> user = userRemoteService.getUser(userId);
        return user.isSuccess() ? user.getData().getNickname() : "";
    }

}