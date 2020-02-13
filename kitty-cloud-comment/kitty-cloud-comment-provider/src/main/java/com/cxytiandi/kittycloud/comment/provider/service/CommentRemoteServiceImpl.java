package com.cxytiandi.kittycloud.comment.provider.service;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentResponse;
import com.cxytiandi.kittycloud.comment.api.service.CommentRemoteService;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论RPC/REST接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@RestController
public class CommentRemoteServiceImpl implements CommentRemoteService {

    @Override
    public ResponseData<String> saveComment(CommentSaveRequest request) {
        return null;
    }

    @Override
    public ResponseData<Boolean> removeComment(String id) {
        return null;
    }

    @Override
    public ResponseData<CommentResponse> getComment(String id) {
        return null;
    }

}