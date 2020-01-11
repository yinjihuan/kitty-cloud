package com.cxytiandi.kittycloud.user.biz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 用户状态枚举
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
public enum UserStatusEnum {

    /**
     * 无效
     */
    INVALID(0, "无效"),
    /**
     * 有效
     */
    VALID(1, "有效");

    UserStatusEnum(int status, String descp) {
        this.status = status;
        this.descp = descp;
    }

    /**
     * 状态
     */
    @EnumValue
    private int status;

    /**
     * 描述
     */
    private String descp;

}
