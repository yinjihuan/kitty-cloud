package com.cxytiandi.kittycloud.article.api.service;

import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 文章REST/RPC接口
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
public interface ArticleRemoteService {

    @GetMapping("/article/{articleId}")
    ResponseData<ArticleResponse> getArticle(@PathVariable  int articleId);

}
