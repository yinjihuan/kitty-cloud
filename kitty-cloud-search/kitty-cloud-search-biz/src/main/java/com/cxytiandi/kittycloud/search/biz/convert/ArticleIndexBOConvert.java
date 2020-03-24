package com.cxytiandi.kittycloud.search.biz.convert;

import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.search.biz.bo.ArticleIndexBO;
import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-24 23:43
 */
@Component
public class ArticleIndexBOConvert implements EntityConvert<ArticleDocument, ArticleIndexBO> {

    @Override
    public ArticleIndexBO convert(ArticleDocument source) {
        ArticleIndexBO articleIndexBO = new ArticleIndexBO();
        BeanUtils.copyProperties(source, articleIndexBO);
        return articleIndexBO;
    }

}