package com.cxytiandi.kittycloud.user.biz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
/**
 * 性别枚举
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public enum SexEnum {

    /**
     * 男
     */
    MALE(0, "男"),
    /**
     * 女
     */
    FEMALE(1, "女");

    SexEnum(int sex, String descp) {
        this.sex = sex;
        this.descp = descp;
    }

    /**
     * 性别
     */
    @EnumValue
    private int sex;

    /**
     * 描述
     */
    private String descp;

    public int getSex() {
        return sex;
    }

    public String getDescp() {
        return descp;
    }
}
