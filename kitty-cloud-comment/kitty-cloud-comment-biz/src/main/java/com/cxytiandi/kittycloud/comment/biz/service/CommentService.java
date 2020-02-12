package com.cxytiandi.kittycloud.comment.biz.service;

import com.cxytiandi.kittycloud.comment.biz.param.CommentReplySaveParam;
import com.cxytiandi.kittycloud.comment.biz.param.CommentSaveParam;

public interface CommentService {

    /**
     * 保存评论
     * @param param 评论参数
     * @return 评论ID
     */
    String saveComment(CommentSaveParam param);

    /**
     * 保存评论回复
     * @param param 评论回复参数
     * @return 回复ID
     */
    String saveCommentReply(CommentReplySaveParam param);

}
