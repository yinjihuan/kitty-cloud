package com.cxytiandi.kittycloud.comment.provider.service;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentReplyResponse;
import com.cxytiandi.kittycloud.comment.api.service.CommentReplyRemoteService;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.RestController;

/**
 * 评论回复RPC/REST接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@RestController
public class CommentReplyRemoteServiceImpl implements CommentReplyRemoteService {

    @Override
    public ResponseData<String> saveCommentReply(CommentSaveRequest request) {
        return null;
    }

    @Override
    public ResponseData<Boolean> removeCommentReply(String id) {
        return null;
    }

    @Override
    public ResponseData<CommentReplyResponse> getCommentReply(String id) {
        return null;
    }

}