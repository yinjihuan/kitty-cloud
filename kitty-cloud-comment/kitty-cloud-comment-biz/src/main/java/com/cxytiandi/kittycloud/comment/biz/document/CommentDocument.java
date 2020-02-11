package com.cxytiandi.kittycloud.comment.biz.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "comment")
public class CommentDocument {

    /**
     * ID
     */
    @Id
    private String id;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 评论业务类型
     */
    private String commentBizType;

    /**
     * 评论业务ID
     */
    private String commentBizId;

    /**
     * 评论业务用户ID
     */
    private Long commentBizUserId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 评论的回复
     */
    private List<CommentReplyDocument> replys;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}