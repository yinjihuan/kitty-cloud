package com.cxytiandi.kittycloud.article.api.fallback;

import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.article.api.service.ArticleRemoteService;
import com.cxytiandi.kittycloud.common.base.Page;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

/**
 * Feign ArticleRemoteService回退逻辑
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-06 19:48
 */
@Slf4j
@Component
public class ArticleRemoteServiceFallbackFactory implements FallbackFactory<ArticleRemoteService> {

    @Override
    public ArticleRemoteService create(Throwable cause) {
        return new ArticleRemoteService() {
            @Override
            public ResponseData<ArticleResponse> getArticle(Long articleId) {
                log.error(MessageFormat.format("ArticleRemoteService.getArticle fallback，参数为 [{0}]", articleId));
                return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
            }

            @Override
            public ResponseData<Page<ArticleResponse>> listHotArticles(int page, int pageSize) {
                log.error(MessageFormat.format("ArticleRemoteService.listHotArticles fallback，参数为 [{0}] [{1}]", page, pageSize));
                return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
            }

            @Override
            public ResponseData<Page<ArticleResponse>> listNewestArticles(int page, int pageSize) {
                log.error(MessageFormat.format("ArticleRemoteService.listNewestArticles fallback，参数为 [{0}] [{1}]", page, pageSize));
                return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
            }
        };
    }
}