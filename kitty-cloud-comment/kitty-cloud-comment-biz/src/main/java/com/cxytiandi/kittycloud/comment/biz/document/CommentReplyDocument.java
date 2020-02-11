package com.cxytiandi.kittycloud.comment.biz.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

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