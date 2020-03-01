package com.cxytiandi.kittycloud.user.api.service;

import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.user.api.fallback.UserRemoteServiceFallbackFactory;
import com.cxytiandi.kittycloud.user.api.request.UserLoginRequest;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户PRC/REST接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@FeignClient(name = "kitty-cloud-user-provider", fallbackFactory = UserRemoteServiceFallbackFactory.class)
public interface UserRemoteService {

    /**
     * 根据用户ID查询用户
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/users/{userId}")
    ResponseData<UserResponse> getUser(@PathVariable("userId") Long userId);

    /**
     * 用户登录
     * @param loginRequest 登录参数
     * @return token
     */
    @PostMapping("/users/login")
    ResponseData<String> login(@RequestBody UserLoginRequest loginRequest);

}
