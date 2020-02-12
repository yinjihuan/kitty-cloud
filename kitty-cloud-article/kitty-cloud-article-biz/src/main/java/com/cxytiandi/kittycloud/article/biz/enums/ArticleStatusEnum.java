package com.cxytiandi.kittycloud.article.biz.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 文章状态枚举
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
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

    public int getStatus() {
        return status;
    }

    public String getDescp() {
        return descp;
    }
}
