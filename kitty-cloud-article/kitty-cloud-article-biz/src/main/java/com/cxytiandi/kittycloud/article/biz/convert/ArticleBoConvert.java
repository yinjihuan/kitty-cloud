package com.cxytiandi.kittycloud.article.biz.convert;


import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;
import com.cxytiandi.kittycloud.article.biz.dataobject.ArticleDO;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ArticleBoConvert implements EntityConvert<ArticleDO, ArticleBO> {

    @Override
    public ArticleBO convert(ArticleDO source) {
        ArticleBO target = new ArticleBO();
        BeanUtils.copyProperties(source, target);
        return target;
    }

}