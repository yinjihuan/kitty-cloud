package com.cxytiandi.kittycloud.comment.biz.param;

import lombok.Data;


/**
 * 评论保存参数
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Data
public class CommentSaveParam {

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论业务类型
     */
    private int commentBizType;

    /**
     * 评论业务ID
     */
    private String commentBizId;

    /**
     * 评论业务的用户ID
     */
    private Long commentBizUserId;

    /**
     * 用户ID
     */
    private Long userId;

}