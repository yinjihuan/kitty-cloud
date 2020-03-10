package com.cxytiandi.kittycloud.search.provider.convert;

import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.search.api.request.ArticleIndexSaveRequest;
import com.cxytiandi.kittycloud.search.biz.param.ArticleIndexSaveParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 文章索引保存参数转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 22:45
 */
@Component
public class ArticleIndexSaveParamConvert implements EntityConvert<ArticleIndexSaveRequest, ArticleIndexSaveParam> {

    @Override
    public ArticleIndexSaveParam convert(ArticleIndexSaveRequest source) {
        ArticleIndexSaveParam param = new ArticleIndexSaveParam();
        BeanUtils.copyProperties(source, param);
        return param;
    }
}