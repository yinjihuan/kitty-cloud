package com.cxytiandi.kittycloud.comment.api.fallback;

import com.cxytiandi.kittycloud.comment.api.request.CommentQueryRequest;
import com.cxytiandi.kittycloud.comment.api.request.CommentSaveRequest;
import com.cxytiandi.kittycloud.comment.api.response.CommentResponse;
import com.cxytiandi.kittycloud.comment.api.service.CommentRemoteService;
import com.cxytiandi.kittycloud.common.base.Page;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-05 21:19
 */
@Slf4j
@Component
public class CommentRemoteServiceFallbackFactory implements FallbackFactory<CommentRemoteService> {

    @Override
    public CommentRemoteService create(Throwable cause) {
        return new CommentRemoteService() {
            @Override
            public ResponseData<String> saveComment(CommentSaveRequest request) {
                log.error(MessageFormat.format("CommentRemoteService.saveComment fallback，参数为 [{0}]", request), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }

            @Override
            public ResponseData<Boolean> removeComment(String id) {
                log.error(MessageFormat.format("CommentRemoteService.removeComment fallback，参数为 [{0}]", id), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }

            @Override
            public ResponseData<Page<CommentResponse>> listComments(CommentQueryRequest request) {
                log.error(MessageFormat.format("CommentRemoteService.listComments fallback，参数为 [{0}]", request), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }
        };
    }
}