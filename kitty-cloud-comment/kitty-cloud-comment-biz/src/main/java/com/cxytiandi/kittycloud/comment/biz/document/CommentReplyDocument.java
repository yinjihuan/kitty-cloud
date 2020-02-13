package com.cxytiandi.kittycloud.comment.biz.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * 评论回复Document
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@Data
@Document(collection = "comment_reply")
public class CommentReplyDocument {

    /**
     * ID
     */
    @Id
    private String id;

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

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}