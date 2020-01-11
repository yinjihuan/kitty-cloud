package com.cxytiandi.kittycloud.user.api.response;

import lombok.Data;

/**
 * @author: yinjihuan
 * @create: 2019-12-26 21:52
 */
@Data
public class UserResponse {

    /**
     * 用户ID
     */
    private int id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 头像
     */
    private String headImg;

}