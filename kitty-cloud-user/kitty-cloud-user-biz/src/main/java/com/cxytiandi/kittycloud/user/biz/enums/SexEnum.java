package com.cxytiandi.kittycloud.user.biz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
/**
 * 性别枚举
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
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
