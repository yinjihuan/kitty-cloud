package com.cxytiandi.kittycloud.article.api.service;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseCode;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;

/**
 * Dubbo ArticleRemoteService回退逻辑
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-06 19:37
 */
@Slf4j
public class ArticleRemoteServiceMock implements ArticleRemoteService {

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

    @Override
    public ResponseData<Page<ArticleResponse>> listArticles(int page, int pageSize) {
        log.error(MessageFormat.format("ArticleRemoteService.listArticles fallback，参数为 [{0}] [{1}]", page, pageSize));
        return Response.fail("fallback", ResponseCode.SERVER_DOWNGRADE_CODE);
    }
}