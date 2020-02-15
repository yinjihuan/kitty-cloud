package com.cxytiandi.kittycloud.comment.biz.dao;

import com.cxytiandi.kittycloud.comment.biz.document.CommentDocument;
import com.cxytiandi.kittycloud.comment.biz.document.CommentReplyDocument;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;

/**
 * 评论DAO
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public interface CommentDao {

    /**
     * 保存评论
     * @param commentDocument 评论参数
     * @return 评论ID
     */
    String saveComment(CommentDocument commentDocument);

    /**
     * 删除评论（包括回复）
     * @param id
     * @return
     */
    boolean removeComment(String id);

    /**
     * 保存评论回复
     * @param commentId 评论ID
     * @param commentReplyDocument 回复参数
     * @return 回复ID
     */
    String saveCommentReply(String commentId, CommentReplyDocument commentReplyDocument);

}
