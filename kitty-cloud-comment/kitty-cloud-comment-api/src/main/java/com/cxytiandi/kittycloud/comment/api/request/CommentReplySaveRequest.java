package com.cxytiandi.kittycloud.comment.api.request;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 评论回复Request
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Data
@Builder
@ToString
public class CommentReplySaveRequest implements Serializable {

    /**
     * 评论ID
     */
    private String commentId;

    /**
     * 回复内容
     */
    private String content;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 回复引用的用户ID
     */
    private Long replayRefUserId;

}