package com.cxytiandi.kittycloud.user.api.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: yinjihuan
 * @create: 2019-12-26 21:52
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