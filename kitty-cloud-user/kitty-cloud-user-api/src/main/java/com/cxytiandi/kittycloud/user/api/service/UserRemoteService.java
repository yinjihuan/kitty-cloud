package com.cxytiandi.kittycloud.user.api.service;

import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "kitty-cloud-user-provider")
public interface UserRemoteService {

    /**
     * 根据用户ID查询用户
     * @param userId 用户ID
     * @return
     */
    @GetMapping("/user/{userId}")
    ResponseData<UserResponse> getUser(@PathVariable("userId") Long userId);

}
