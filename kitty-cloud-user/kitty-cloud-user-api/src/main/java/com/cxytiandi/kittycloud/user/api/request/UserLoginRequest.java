package com.cxytiandi.kittycloud.user.api.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 用户登录Request
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Data
@ToString
public class UserLoginRequest implements Serializable {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pass;

}