package com.cxytiandi.kittycloud.article.biz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 文章状态枚举
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
public enum ArticleStatusEnum {

    /**
     * 无效
     */
    INVALID(0, "无效"),
    /**
     * 有效
     */
    VALID(1, "有效");

    ArticleStatusEnum(int status, String descp) {
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
