package com.cxytiandi.kittycloud.search.api.service;

import com.cxytiandi.kitty.common.page.Page;
import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.search.api.fallback.ArticleIndexRemoteServiceFallbackFactory;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSearchRequest;
import com.cxytiandi.kittycloud.search.api.response.ArticleIndexResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 文章索引RPC/REST接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 23:40
 */
@FeignClient(name = "kitty-cloud-search-provider", fallbackFactory = ArticleIndexRemoteServiceFallbackFactory.class)
public interface ArticleIndexRemoteService {

    /**
     * 保存文章索引
     * @param request
     * @return
     */
    @PostMapping("/articles")
    ResponseData<Boolean> saveArticleIndex(@RequestBody ArticleIndexSaveRequest request);

    /**
     * 搜索文章
     * @param request
     * @return
     */
    @GetMapping("/articles")
    ResponseData<Page<ArticleIndexResponse>> searchArticleIndex(@SpringQueryMap ArticleIndexSearchRequest request);

}
