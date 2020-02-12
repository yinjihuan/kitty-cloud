package com.cxytiandi.kittycloud.comment.provider.service;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentReplyResponse;
import com.cxytiandi.kittycloud.comment.api.service.CommentReplyRemoteService;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yinjihuan
 * @create: 2020-02-12 20:44
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