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

@Service(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP)
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
        return Response.ok("xxxxxxxxx");
    }

}