package com.cxytiandi.kittycloud.mqconsume.es.listener;

import com.cxytiandi.kittycloud.mqconsume.es.enums.ChangeTypeEnum;
import com.cxytiandi.kittycloud.mqconsume.es.event.DataChangeEvent;
import com.cxytiandi.kittycloud.mqconsume.es.factory.ArticleIndexServiceFactory;
import com.cxytiandi.kittycloud.mqconsume.es.service.ArticleIndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 22:21
 */
@Slf4j
@Component
public class DataChangeEventListener {

    @Autowired
    private ArticleIndexServiceFactory articleIndexServiceFactory;

    /**
     * 文章索引更新
     * @param event
     */
    @Async
    @EventListener
    public void onArticleIndexChangeEvent(DataChangeEvent event) {
        ArticleIndexService articleIndexService = articleIndexServiceFactory.getArticleIndexService(ChangeTypeEnum.from(event.getChangeType()));
        if (articleIndexService != null) {
            articleIndexService.changeArticleIndex(event);
        }
        log.info("articleIndexChange Thread {}", Thread.currentThread().getName());
    }

    /**
     * 评论索引更新
     * @param event
     */
    @Async
    @EventListener
    public void onCommentIndexChangeEvent(DataChangeEvent event) {
        log.info("commentIndexChange Thread {}", Thread.currentThread().getName());
    }

}