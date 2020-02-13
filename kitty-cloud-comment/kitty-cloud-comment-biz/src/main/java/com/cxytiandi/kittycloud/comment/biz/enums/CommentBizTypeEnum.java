package com.cxytiandi.kittycloud.comment.biz.enums;


import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.exception.BizException;

/**
 * 评论业务类型枚举
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
public enum CommentBizTypeEnum {

    /**
     * 文章
     */
    ARTICLE(0, "文章"),
    /**
     * 问题
     */
    QUESTION(1, "问题");

    CommentBizTypeEnum(int type, String descp) {
        this.type = type;
        this.descp = descp;
    }

    /**
     * 类型
     */
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

    public static CommentBizTypeEnum fromType(int type) {
        for (CommentBizTypeEnum commentBizTypeEnum : CommentBizTypeEnum.values()) {
            if (commentBizTypeEnum.getType() == type) {
                return commentBizTypeEnum;
            }
        }
        return null;
    }

}
