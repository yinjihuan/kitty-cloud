package com.cxytiandi.kittycloud.user.provider.convert;


import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.biz.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserResponseConvert implements EntityConvert<UserBO, UserResponse> {

    @Override
    public UserResponse convert(UserBO source) {
        UserResponse target = new UserResponse();
        BeanUtils.copyProperties(source, target);
        return target;
    }

}