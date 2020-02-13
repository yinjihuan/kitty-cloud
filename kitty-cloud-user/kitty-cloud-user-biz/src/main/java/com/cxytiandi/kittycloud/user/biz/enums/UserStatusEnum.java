package com.cxytiandi.kittycloud.user.biz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 用户状态枚举
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
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

    public String getDescp() {
        return descp;
    }

    public int getStatus() {
        return status;
    }
}
