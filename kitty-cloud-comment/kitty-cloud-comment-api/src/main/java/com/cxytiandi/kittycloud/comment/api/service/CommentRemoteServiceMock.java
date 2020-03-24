package com.cxytiandi.kittycloud.comment.api.service;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.comment.api.request.CommentQueryRequest;
import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentResponse;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

/**
 * Dubbo CommentRemoteService回退逻辑
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-05 21:46
 */
@Slf4j
public class CommentRemoteServiceMock implements CommentRemoteService {

    @Override
    public ResponseData<String> saveComment(CommentSaveRequest request) {
        log.error(MessageFormat.format("CommentRemoteService.saveComment fallback，参数为 [{0}]", request));
        return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
    }

    @Override
    public ResponseData<Boolean> removeComment(String id) {
        log.error(MessageFormat.format("CommentRemoteService.removeComment fallback，参数为 [{0}]", id));
        return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
    }

    @Override
    public ResponseData<Page<CommentResponse>> listComments(CommentQueryRequest request) {
        log.error(MessageFormat.format("CommentRemoteService.listComments fallback，参数为 [{0}]", request));
        return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
    }
}