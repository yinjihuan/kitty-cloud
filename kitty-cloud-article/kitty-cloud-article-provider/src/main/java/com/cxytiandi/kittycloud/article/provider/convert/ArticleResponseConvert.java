package com.cxytiandi.kittycloud.article.provider.convert;

import com.cxytiandi.kittycloud.article.api.response.ArticleResponse;
import com.cxytiandi.kittycloud.article.biz.bo.ArticleBO;
import com.cxytiandi.kittycloud.common.base.EntityConvert;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 文章Response转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@Component
public class ArticleResponseConvert implements EntityConvert<ArticleBO, ArticleResponse> {

    @Override
    public ArticleResponse convert(ArticleBO source) {
        ArticleResponse target = new ArticleResponse();
        BeanUtils.copyProperties(source, target);
        target.setTags(Arrays.asList(source.getTags().split(",")));
        return target;
    }

}