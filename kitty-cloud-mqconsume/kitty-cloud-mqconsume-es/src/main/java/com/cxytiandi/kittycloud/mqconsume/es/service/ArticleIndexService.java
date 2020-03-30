package com.cxytiandi.kittycloud.mqconsume.es.service;

import com.cxytiandi.kittycloud.mqconsume.es.enums.ChangeTypeEnum;
import com.cxytiandi.kittycloud.mqconsume.es.event.DataChangeEvent;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 22:40
 */
public interface ArticleIndexService {

    void changeArticleIndex(DataChangeEvent event);

    ChangeTypeEnum changeType();

}
