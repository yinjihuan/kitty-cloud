package com.cxytiandi.kittycloud.user.provider.service;

import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.api.service.UserRemoteService;
import com.cxytiandi.kittycloud.user.biz.bo.UserBO;
import com.cxytiandi.kittycloud.user.biz.service.UserService;
import com.cxytiandi.kittycloud.user.provider.convert.UserResponseConvert;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.dianping.cat.message.Transaction;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@Service(version = "1.0.0")
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

}