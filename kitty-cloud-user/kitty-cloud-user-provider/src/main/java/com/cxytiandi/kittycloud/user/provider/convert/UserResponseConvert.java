package com.cxytiandi.kittycloud.user.provider.convert;


import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.user.api.response.UserResponse;
import com.cxytiandi.kittycloud.user.biz.bo.UserBO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 用户Response转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Component
public class UserResponseConvert implements EntityConvert<UserBO, UserResponse> {

    @Override
    public UserResponse convert(UserBO source) {
        UserResponse target = new UserResponse();
        BeanUtils.copyProperties(source, target);
        return target;
    }

}