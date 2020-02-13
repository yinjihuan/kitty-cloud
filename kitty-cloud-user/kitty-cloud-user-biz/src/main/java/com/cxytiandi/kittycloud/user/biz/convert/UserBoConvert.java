package com.cxytiandi.kittycloud.user.biz.convert;

import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.exception.BizException;
import com.cxytiandi.kittycloud.user.biz.bo.UserBO;
import com.cxytiandi.kittycloud.user.biz.dataobject.UserDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 用户BO转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Component
public class UserBoConvert implements EntityConvert<UserDO,UserBO> {

    @Override
    public UserBO convert(UserDO source) {
        UserBO target = new UserBO();
        BeanUtils.copyProperties(source, target);
        return target;
    }

}