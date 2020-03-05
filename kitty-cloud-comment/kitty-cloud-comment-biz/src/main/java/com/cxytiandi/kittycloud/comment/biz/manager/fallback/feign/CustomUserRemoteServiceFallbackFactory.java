package com.cxytiandi.kittycloud.comment.biz.manager.fallback.feign;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.user.api.fallback.UserRemoteServiceFallbackFactory;
import com.cxytiandi.kittycloud.user.api.request.UserLoginRequest;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * 自定义 Feign 回退逻辑，可以替换服务提供方的默认实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-05 22:21
 */
@Slf4j
@Primary
@Component
public class CustomUserRemoteServiceFallbackFactory extends UserRemoteServiceFallbackFactory {

    @Override
    public UserRemoteService create(Throwable cause) {
        return new UserRemoteService() {
            @Override
            public ResponseData<UserResponse> getUser(Long userId) {
                log.error(MessageFormat.format("UserRemoteService.getUser fallback，参数为 [{0}]", userId), cause);
                UserResponse userResponse = new UserResponse();
                userResponse.setNickname("尹吉欢");
                return Response.ok(userResponse);
            }

            @Override
            public ResponseData<String> login(UserLoginRequest loginRequest) {
                log.error(MessageFormat.format("UserRemoteService.login fallback，参数为 [{0}]", loginRequest), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }
        };
    }

}