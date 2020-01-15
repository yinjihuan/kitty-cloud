package com.cxytiandi.kittycloud.article.biz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 文章类型枚举
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
public enum ArticleTypeEnum {

    /**
     * 原创
     */
    ORIGINAL(0, "原创"),
    /**
     * 转载
     */
    REPRINT(1, "转载"),

    /**
     * 翻译
     */
    TRANSLATE(2, "转载");

    ArticleTypeEnum(int type, String descp) {
        this.type = type;
        this.descp = descp;
    }

    /**
     * 类型
     */
    @EnumValue
    private int type;

    /**
     * 描述
     */
    private String descp;

}
