package com.cxytiandi.kittycloud.comment.biz.service;

import com.cxytiandi.kittycloud.comment.biz.param.CommentReplySaveParam;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;

/**
 * 评论业务接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public interface CommentService {

    /**
     * 保存评论
     * @param param 评论参数
     * @return 评论ID
     */
    String saveComment(CommentSaveParam param);

    /**
     * 删除评论（包括回复）
     * @param id
     * @return
     */
    boolean removeComment(String id);

    /**
     * 保存评论回复
     * @param param 评论回复参数
     * @return 回复ID
     */
    String saveCommentReply(CommentReplySaveParam param);

    /**
     * 删除评论回复
     * @param replyId 回复ID
     * @return
     */
    boolean removeCommentReply(String replyId);

}
