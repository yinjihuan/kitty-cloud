package com.cxytiandi.kittycloud.user.api.service;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.user.api.request.UserLoginRequest;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

/**
 * Dubbo UserRemoteService回退逻辑
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-27 22:11
 */
@Slf4j
public class UserRemoteServiceMock implements UserRemoteService {

    @Override
    public ResponseData<UserResponse> getUser(Long userId) {
        log.error(MessageFormat.format("UserRemoteService.getUser fallback，参数为 [{0}]", userId));
        return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
    }

    @Override
    public ResponseData<String> login(UserLoginRequest loginRequest) {
        return null;
    }
}