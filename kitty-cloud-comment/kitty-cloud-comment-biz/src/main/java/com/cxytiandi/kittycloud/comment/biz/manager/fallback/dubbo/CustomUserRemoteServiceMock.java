package com.cxytiandi.kittycloud.comment.biz.manager.fallback.dubbo;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.user.api.request.UserLoginRequest;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

/**
 * 自定义Dubbo UserRemoteService回退逻辑，可以替换服务提供方的默认实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-27 22:11
 */
@Slf4j
public class CustomUserRemoteServiceMock implements UserRemoteService {

    @Override
    public ResponseData<UserResponse> getUser(Long userId) {
        log.error(MessageFormat.format("UserRemoteService.getUser fallback，参数为 [{0}]", userId));
        UserResponse userResponse = new UserResponse();
        userResponse.setNickname("尹吉欢");
        return Response.ok(userResponse);
    }

    @Override
    public ResponseData<String> login(UserLoginRequest loginRequest) {
        return null;
    }
}