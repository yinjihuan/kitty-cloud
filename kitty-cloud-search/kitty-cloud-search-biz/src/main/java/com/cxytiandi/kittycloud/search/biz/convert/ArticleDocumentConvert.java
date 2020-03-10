package com.cxytiandi.kittycloud.search.biz.convert;

import com.cxytiandi.kittycloud.common.base.EntityConvert;
import com.cxytiandi.kittycloud.search.biz.document.ArticleDocument;
import com.cxytiandi.kittycloud.search.biz.param.ArticleIndexSaveParam;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 22:50
 */
@Component
public class ArticleDocumentConvert implements EntityConvert<ArticleIndexSaveParam, ArticleDocument> {

    @Override
    public ArticleDocument convert(ArticleIndexSaveParam source) {
        ArticleDocument document = new ArticleDocument();
        BeanUtils.copyProperties(source, document);
        return document;
    }
}