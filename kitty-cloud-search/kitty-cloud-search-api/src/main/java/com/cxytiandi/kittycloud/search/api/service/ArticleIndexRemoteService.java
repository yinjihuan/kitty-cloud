package com.cxytiandi.kittycloud.search.api.service;

import com.cxytiandi.kittycloud.common.base.ResponseData;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
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
public interface ArticleIndexRemoteService {

    /**
     * 保存文章索引
     * @param request
     * @return
     */
    ResponseData<Boolean> saveArticleIndex(@RequestBody ArticleIndexSaveRequest request);

}
