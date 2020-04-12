package com.cxytiandi.kittycloud.user.biz.service.impl;

import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.exception.BizException;
import com.cxytiandi.kittycloud.common.helper.JWTHelper;
import com.cxytiandi.kittycloud.user.biz.bo.UserBO;
import com.cxytiandi.kittycloud.user.biz.convert.UserBoConvert;
import com.cxytiandi.kittycloud.user.biz.dao.UserDao;
import com.cxytiandi.kittycloud.user.biz.dataobject.UserDO;
import com.cxytiandi.kittycloud.user.biz.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户业务接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserBoConvert userBoConvert;

    @Autowired
    private JWTHelper jwtHelper;

    @Override
    public UserBO getUser(Long id) {
        log.info("查询用户 [{}]", id);
        if (id == null) {
            throw new BizException(ResponseCode.PARAM_ERROR_CODE, "id不能为空");
        }

        UserDO userDO = userDao.getById(id);
        if (userDO == null) {
            throw new BizException(ResponseCode.NOT_FOUND_CODE);
        }

        return userBoConvert.convert(userDO);
    }

    @Override
    public String login(String username, String pass) {
        UserDO userDO = userDao.getByUsernameAndPass(username, pass);
        if (userDO == null) {
            throw new BizException(ResponseCode.USER_LOGIN_ERROR_CODE);
        }

        return jwtHelper.getToken(userDO.getId().toString());
    }

}