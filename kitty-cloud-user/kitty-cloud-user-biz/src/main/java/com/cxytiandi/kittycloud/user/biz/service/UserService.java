package com.cxytiandi.kittycloud.user.biz.service;

import com.cxytiandi.kittycloud.user.biz.bo.UserBO;

/**
 * 用户业务接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public interface UserService {

    /**
     * 获取用户
     * @param id 用户ID
     * @return
     */
    UserBO getUser(Long id);

    /**
     * 用户登录
     * @param username 用户名
     * @param pass 密码
     * @return
     */
    String login(String username, String pass);

}
