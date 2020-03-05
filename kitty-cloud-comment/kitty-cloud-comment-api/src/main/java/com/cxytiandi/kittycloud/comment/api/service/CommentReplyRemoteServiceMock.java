package com.cxytiandi.kittycloud.comment.api.service;

import com.cxytiandi.kittycloud.comment.api.request.CommentReplySaveRequest;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

/**
 * Dubbo CommentReplyRemoteService回退逻辑
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-05 21:53
 */
@Slf4j
public class CommentReplyRemoteServiceMock implements CommentReplyRemoteService {

    @Override
    public ResponseData<String> saveCommentReply(CommentReplySaveRequest request) {
        log.error(MessageFormat.format("CommentReplyRemoteService.saveCommentReply fallback，参数为 [{0}]", request));
        return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
    }

    @Override
    public ResponseData<Boolean> removeCommentReply(String id) {
        log.error(MessageFormat.format("CommentReplyRemoteService.removeCommentReply fallback，参数为 [{0}]", id));
        return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
    }
}