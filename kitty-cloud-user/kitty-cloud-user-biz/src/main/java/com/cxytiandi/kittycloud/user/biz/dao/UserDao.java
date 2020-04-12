package com.cxytiandi.kittycloud.user.biz.dao;

import com.cxytiandi.kittycloud.user.biz.dataobject.UserDO;

/**
 * 用户DAO
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public interface UserDao {

    /**
     * 获取用户信息
     * @param id 用户ID
     * @return 用户DO
     */
    UserDO getById(Long id);

    /**
     * 用户登录
     * @param username 用户名
     * @param pass 密码
     * @return 用户DO
     */
    UserDO getByUsernameAndPass(String username, String pass);

}
