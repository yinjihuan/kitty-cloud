package com.cxytiandi.kittycloud.user.biz.service.impl;

import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.exception.BizException;
import com.cxytiandi.kittycloud.user.biz.bo.UserBO;
import com.cxytiandi.kittycloud.user.biz.convert.UserBoConvert;
import com.cxytiandi.kittycloud.user.biz.dao.UserDao;
import com.cxytiandi.kittycloud.user.biz.dataobject.UserDO;
import com.cxytiandi.kittycloud.user.biz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBoConvert userBoConvert;

    @Override
    public UserBO getUser(Long id) {
        if (id == null) {
            throw new BizException(ResponseCode.PARAM_ERROR_CODE);
        }

        UserDO userDO = userDao.selectById(id);
        if (userDO == null) {
            throw new BizException(ResponseCode.NOT_FOUND_CODE);
        }

        return userBoConvert.convert(userDO);
    }

}