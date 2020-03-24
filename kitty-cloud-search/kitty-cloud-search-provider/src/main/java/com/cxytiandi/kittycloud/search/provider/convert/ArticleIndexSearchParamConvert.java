package com.cxytiandi.kittycloud.search.provider.convert;

import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSearchRequest;
import com.cxytiandi.kittycloud.search.biz.param.ArticleIndexSearchParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-24 23:48
 */
@Component
public class ArticleIndexSearchParamConvert implements EntityConvert<ArticleIndexSearchRequest, ArticleIndexSearchParam>  {

    @Override
    public ArticleIndexSearchParam convert(ArticleIndexSearchRequest source) {
        ArticleIndexSearchParam param = new ArticleIndexSearchParam();
        BeanUtils.copyProperties(source, param);
        return param;
    }
}