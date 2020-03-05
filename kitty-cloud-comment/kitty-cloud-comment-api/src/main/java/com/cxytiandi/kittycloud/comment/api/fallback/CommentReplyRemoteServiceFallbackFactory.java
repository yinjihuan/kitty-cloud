package com.cxytiandi.kittycloud.comment.api.fallback;

import com.cxytiandi.kittycloud.comment.api.request.CommentReplySaveRequest;
import com.cxytiandi.kittycloud.comment.api.service.CommentReplyRemoteService;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Feign CommentReplyRemoteService回退逻辑
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-05 21:26
 */
@Slf4j
@Component
public class CommentReplyRemoteServiceFallbackFactory implements FallbackFactory<CommentReplyRemoteService> {

    @Override
    public CommentReplyRemoteService create(Throwable cause) {
        return new CommentReplyRemoteService() {
            @Override
            public ResponseData<String> saveCommentReply(CommentReplySaveRequest request) {
                log.error(MessageFormat.format("CommentReplyRemoteService.saveCommentReply fallback，参数为 [{0}]", request), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }

            @Override
            public ResponseData<Boolean> removeCommentReply(String id) {
                log.error(MessageFormat.format("CommentReplyRemoteService.removeCommentReply fallback，参数为 [{0}]", id), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }
        };
    }
}