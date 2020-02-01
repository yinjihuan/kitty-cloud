package com.cxytiandi.kittycloud.article.biz.convert;


import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;
import com.cxytiandi.kittycloud.article.biz.dataobject.ArticleDO;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ArticleBoConvert implements EntityConvert<ArticleDO, ArticleBO> {

    public ArticleBO convertPlus(ArticleDO source, String username) {
        ArticleBO target = new ArticleBO();
        BeanUtils.copyProperties(source, target);
        target.setUsername(username);
        return target;
    }

}