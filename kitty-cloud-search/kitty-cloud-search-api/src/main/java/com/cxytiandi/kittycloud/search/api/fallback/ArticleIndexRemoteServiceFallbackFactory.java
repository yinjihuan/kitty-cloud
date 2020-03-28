package com.cxytiandi.kittycloud.search.api.fallback;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSearchRequest;
import com.cxytiandi.kittycloud.search.api.response.ArticleIndexResponse;
import com.cxytiandi.kittycloud.search.api.service.ArticleIndexRemoteService;
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
 * @时间 2020-03-28 11:51
 */
@Slf4j
@Component
public class ArticleIndexRemoteServiceFallbackFactory implements FallbackFactory<ArticleIndexRemoteService> {

    @Override
    public ArticleIndexRemoteService create(Throwable cause) {
        return new ArticleIndexRemoteService() {
            @Override
            public ResponseData<Boolean> saveArticleIndex(ArticleIndexSaveRequest request) {
                log.error(MessageFormat.format("ArticleIndexRemoteService.saveArticleIndex fallback，参数为 [{0}]", request), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }

            @Override
            public ResponseData<Page<ArticleIndexResponse>> searchArticleIndex(ArticleIndexSearchRequest request) {
                log.error(MessageFormat.format("ArticleIndexRemoteService.searchArticleIndex fallback，参数为 [{0}]", request), cause);
                return Response.fail(cause.getMessage(), ResponseCode.SERVER_DOWNGRADE_CODE);
            }
        };
    }
}