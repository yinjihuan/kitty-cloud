package com.cxytiandi.kittycloud.article.biz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 文章类型枚举
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
public enum ArticleTypeEnum {

    /**
     * 原创
     */
    ORIGINAL(1, "原创"),
    /**
     * 转载
     */
    REPRINT(2, "转载"),

    /**
     * 翻译
     */
    TRANSLATE(3, "转载");

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

    public int getType() {
        return type;
    }

    public String getDescp() {
        return descp;
    }
}
