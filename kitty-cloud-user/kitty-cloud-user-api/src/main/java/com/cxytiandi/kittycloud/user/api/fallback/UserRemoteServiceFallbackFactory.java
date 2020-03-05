package com.cxytiandi.kittycloud.user.api.fallback;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.user.api.request.UserLoginRequest;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Feign UserRemoteService回退逻辑
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-27 20:36
 */
@Slf4j
@Component
public class UserRemoteServiceFallbackFactory implements FallbackFactory<UserRemoteService> {

    @Override
    public UserRemoteService create(Throwable cause) {
        return new UserRemoteService() {
            @Override
            public ResponseData<UserResponse> getUser(Long userId) {
                log.error(MessageFormat.format("UserRemoteService.getUser fallback，参数为 [{0}]", userId), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }

            @Override
            public ResponseData<String> login(UserLoginRequest loginRequest) {
                log.error(MessageFormat.format("UserRemoteService.login fallback，参数为 [{0}]", loginRequest), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }
        };
    }

}