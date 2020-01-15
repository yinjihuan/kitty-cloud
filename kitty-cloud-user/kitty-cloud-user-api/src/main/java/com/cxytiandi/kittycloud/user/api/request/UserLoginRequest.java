package com.cxytiandi.kittycloud.user.api.request;

import lombok.Data;

/**
 * @author: yinjihuan
 * @create: 2020-01-15 22:26
 */
@Data
public class UserLoginRequest {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String pass;

}