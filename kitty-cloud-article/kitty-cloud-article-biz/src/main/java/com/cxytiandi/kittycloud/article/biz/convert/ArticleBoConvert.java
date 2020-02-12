package com.cxytiandi.kittycloud.article.biz.convert;


import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;
import com.cxytiandi.kittycloud.article.biz.dataobject.ArticleDO;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * 文章BO转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@Component
public class ArticleBoConvert implements EntityConvert<ArticleDO, ArticleBO> {

    public ArticleBO convertPlus(ArticleDO source, String nickname) {
        ArticleBO target = new ArticleBO();
        BeanUtils.copyProperties(source, target);
        target.setNickname(nickname);
        return target;
    }

}