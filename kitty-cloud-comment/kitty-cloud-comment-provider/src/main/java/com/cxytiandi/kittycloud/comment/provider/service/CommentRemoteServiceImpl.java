package com.cxytiandi.kittycloud.comment.provider.service;

import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentResponse;
import com.cxytiandi.kittycloud.comment.api.service.CommentRemoteService;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yinjihuan
 * @create: 2020-02-12 20:43
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