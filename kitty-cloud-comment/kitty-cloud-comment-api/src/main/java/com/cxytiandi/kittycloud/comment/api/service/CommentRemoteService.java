package com.cxytiandi.kittycloud.comment.api.service;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentResponse;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.*;

public interface CommentRemoteService {

    /**
     * 保存评论
     * @param request 评论参数
     * @return 评论ID
     */
    @PostMapping("/comments")
    ResponseData<String> saveComment(@RequestBody CommentSaveRequest request);

    /**
     * 删除评论
     * @param id 评论ID
     * @return 是否删除成功
     */
    @DeleteMapping("/comments/{id}")
    ResponseData<Boolean> removeComment(@PathVariable String id);

    /**
     * 查询评论信息
     * @param id 评论ID
     * @return 评论信息
     */
    @GetMapping("/comments/{id}")
    ResponseData<CommentResponse> getComment(@PathVariable String id);

}
