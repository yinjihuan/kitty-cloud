package com.cxytiandi.kittycloud.search.provider.convert;

import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.search.api.response.ArticleIndexResponse;
import com.cxytiandi.kittycloud.search.biz.bo.ArticleIndexBO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-24 23:52
 */
@Component
public class ArticleIndexResponseConvert implements EntityConvert<ArticleIndexBO, ArticleIndexResponse> {

    @Override
    public ArticleIndexResponse convert(ArticleIndexBO source) {
        ArticleIndexResponse response = new ArticleIndexResponse();
        BeanUtils.copyProperties(source, response);
        return response;
    }
}