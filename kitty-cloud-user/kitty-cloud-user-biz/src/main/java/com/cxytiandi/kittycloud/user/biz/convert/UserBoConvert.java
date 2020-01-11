package com.cxytiandi.kittycloud.user.biz.convert;

import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.user.biz.bo.UserBO;
import com.cxytiandi.kittycloud.user.biz.dataobject.UserDO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserBoConvert implements EntityConvert<UserDO,UserBO> {

    @Override
    public UserBO convert(UserDO source) {
        UserBO target = new UserBO();
        BeanUtils.copyProperties(source, target);
        return target;
    }

}