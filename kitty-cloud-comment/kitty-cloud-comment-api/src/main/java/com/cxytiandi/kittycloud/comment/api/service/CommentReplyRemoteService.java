package com.cxytiandi.kittycloud.comment.api.service;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentReplyResponse;
import com.cxytiandi.kittycloud.comment.api.response.CommentResponse;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.*;

public interface CommentReplyRemoteService {

    /**
     * 保存评论
     * @param request 评论参数
     * @return 评论ID
     */
    @PostMapping("/replys")
    ResponseData<String> saveCommentReply(@RequestBody CommentSaveRequest request);

    /**
     * 删除评论
     * @param id 评论ID
     * @return 是否删除成功
     */
    @DeleteMapping("/replys/{id}")
    ResponseData<Boolean> removeCommentReply(@PathVariable String id);

    /**
     * 查询评论信息
     * @param id 评论ID
     * @return 评论信息
     */
    @GetMapping("/replys/{id}")
    ResponseData<CommentReplyResponse> getCommentReply(@PathVariable String id);

}
