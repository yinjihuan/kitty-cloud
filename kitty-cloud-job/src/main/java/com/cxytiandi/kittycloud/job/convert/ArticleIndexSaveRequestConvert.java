package com.cxytiandi.kittycloud.job.convert;

import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 文章索引保存请求参数转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-28 11:23
 */
@Component
public class ArticleIndexSaveRequestConvert implements EntityConvert<ArticleResponse, ArticleIndexSaveRequest> {

    @Override
    public ArticleIndexSaveRequest convert(ArticleResponse source) {
        ArticleIndexSaveRequest request = new ArticleIndexSaveRequest();
        BeanUtils.copyProperties(source, request);
        return request;
    }
}