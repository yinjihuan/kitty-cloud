package com.cxytiandi.kittycloud.comment.api.service;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.comment.api.fallback.CommentRemoteServiceFallbackFactory;
import com.cxytiandi.kittycloud.comment.api.request.CommentQueryRequest;
import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentResponse;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


/**
 * 评论RPC/REST接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@FeignClient(name = "kitty-cloud-comment-provider", contextId = "CommentRemoteService", fallbackFactory = CommentRemoteServiceFallbackFactory.class)
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
     * 分页查询评论
     * @param request
     * @return
     */
    @GetMapping("/comments")
    ResponseData<Page<CommentResponse>> listComments(CommentQueryRequest request);

}
