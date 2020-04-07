package com.cxytiandi.kittycloud.user.provider.service;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import com.cxytiandi.kittycloud.user.api.request.UserLoginRequest;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import com.cxytiandi.kittycloud.user.biz.bo.UserBO;
import com.cxytiandi.kittycloud.user.biz.service.UserService;
import com.cxytiandi.kittycloud.user.provider.convert.UserResponseConvert;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户PRC/REST接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Service(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP, timeout = 3000)
@RestController
public class UserRemoteServiceImpl implements UserRemoteService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserResponseConvert userResponseConvert;

    @Override
    public ResponseData<UserResponse> getUser(Long userId) {
        UserBO user = userService.getUser(userId);
        return Response.ok(userResponseConvert.convert(user));
    }

    @Override
    public ResponseData<String> login(UserLoginRequest loginRequest) {
        return Response.ok(userService.login(loginRequest.getUsername(), loginRequest.getPass()));
    }

}