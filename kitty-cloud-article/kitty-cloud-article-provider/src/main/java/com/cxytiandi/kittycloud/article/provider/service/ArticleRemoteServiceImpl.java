package com.cxytiandi.kittycloud.article.provider.service;

import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.article.api.service.ArticleRemoteService;
import com.cxytiandi.kittycloud.common.base.Response;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleRemoteServiceImpl implements ArticleRemoteService {

    public ResponseData<ArticleResponse> getArticle(int articleId) {
        return Response.ok(new ArticleResponse());
    }

}