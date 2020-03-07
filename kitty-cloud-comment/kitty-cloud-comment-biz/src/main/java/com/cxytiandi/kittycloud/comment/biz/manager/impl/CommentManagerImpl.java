package com.cxytiandi.kittycloud.comment.biz.manager.impl;

import com.alicp.jetcache.anno.Cached;
import com.cxytiandi.kittycloud.comment.biz.manager.CommentManager;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 评论Manager接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-16 16:04
 */
@Component
public class CommentManagerImpl implements CommentManager {

    // @Reference dubbo调用， @Autowired Feign调用
    @Autowired
    // mock = DubboConstant.MOCK 开启Dubbo默认回退
    //@Reference(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP, check = false, mock = "com.cxytiandi.kittycloud.comment.biz.manager.fallback.dubbo.CustomUserRemoteServiceMock")
    private UserRemoteService userRemoteService;

    //@Cached(name = "CommentManagerImpl:getNickname:", key = "#userId", expire = 1, timeUnit = TimeUnit.DAYS)
    @Override
    public String getNickname(Long userId) {
        ResponseData<UserResponse> user = userRemoteService.getUser(userId);
        return user.isSuccess() ? user.getData().getNickname() : "";
    }
}