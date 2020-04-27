package com.cxytiandi.kittycloud.mqconsume.es.service.impl;

import com.cxytiandi.kittycloud.mqconsume.es.enums.ChangeTypeEnum;
import com.cxytiandi.kittycloud.mqconsume.es.event.DataChangeEvent;
import com.cxytiandi.kittycloud.mqconsume.es.service.ArticleIndexService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 22:40
 */
@Service
public class ArticleIndexSaveServiceImpl implements ArticleIndexService {

    private List<String> consumerTables = Arrays.asList("article");

    @Override
    public void changeArticleIndex(DataChangeEvent event) {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int a = 2/0;
        if (!consumerTables.contains(event.getTable())) {
            return;
        }
    }

    @Override
    public ChangeTypeEnum changeType() {
        return ChangeTypeEnum.INSERT;
    }
}