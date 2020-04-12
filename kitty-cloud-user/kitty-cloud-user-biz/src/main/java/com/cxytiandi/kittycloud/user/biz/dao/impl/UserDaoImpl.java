package com.cxytiandi.kittycloud.user.biz.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cxytiandi.kittycloud.user.biz.dao.UserDao;
import com.cxytiandi.kittycloud.user.biz.dataobject.UserDO;
import com.cxytiandi.kittycloud.user.biz.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 用户DAO实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-12 20:53
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO getById(Long id) {
        return userMapper.selectById(id);
    }

    @Override
    public UserDO getByUsernameAndPass(String username, String pass) {
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mobile", username).eq("pass", pass);

        return userMapper.selectOne(queryWrapper);
    }
}