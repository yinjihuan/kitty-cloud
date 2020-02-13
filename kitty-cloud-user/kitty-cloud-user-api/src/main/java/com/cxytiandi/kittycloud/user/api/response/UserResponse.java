package com.cxytiandi.kittycloud.user.api.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户Response
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Data
public class UserResponse implements Serializable {

    /**
     * 用户ID
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;

    /**
     * 性别
     */
    private int sex;

    /**
     * 个性签名
     */
    private String sign;

    /**
     * 头像地址
     */
    private String headPhotoUrl;

}