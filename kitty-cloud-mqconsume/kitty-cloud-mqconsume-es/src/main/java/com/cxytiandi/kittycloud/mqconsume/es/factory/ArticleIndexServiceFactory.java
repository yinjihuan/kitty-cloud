package com.cxytiandi.kittycloud.mqconsume.es.factory;

import com.cxytiandi.kittycloud.mqconsume.es.enums.ChangeTypeEnum;
import com.cxytiandi.kittycloud.mqconsume.es.service.ArticleIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 文章索引Service工厂类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-30 21:31
 */
@Component
public class ArticleIndexServiceFactory {

    @Autowired
    private List<ArticleIndexService> articleIndexServices;

    public ArticleIndexService getArticleIndexService(ChangeTypeEnum changeType) {
        if (changeType == null) {
            return null;
        }
        return articleIndexServices.stream().filter(s -> s.changeType() == changeType).findAny()
                .orElseGet(null);
    }

}