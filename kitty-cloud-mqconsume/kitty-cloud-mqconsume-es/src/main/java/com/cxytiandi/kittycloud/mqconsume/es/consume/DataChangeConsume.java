package com.cxytiandi.kittycloud.mqconsume.es.consume;

import com.cxytiandi.kittycloud.mqconsume.es.async.support.CustomApplicationContextAware;
import com.cxytiandi.kittycloud.mqconsume.es.event.DataChangeEvent;
import com.cxytiandi.kittycloud.mqconsume.es.async.support.DefaultFuture;
import com.cxytiandi.kittycloud.mqconsume.es.request.DataChangeRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * 数据变动消费者
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 20:22
 */
@Slf4j
@Service
@RocketMQMessageListener(topic = "${rocketmq.topic.data_change}", consumerGroup = "${rocketmq.group.data_change_consumer}")
public class DataChangeConsume implements RocketMQListener<DataChangeRequest> {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CustomApplicationContextAware customApplicationContextAware;

    @Override
    public void onMessage(DataChangeRequest dataChangeRequest) {
        log.info("received message {} , Thread {}", dataChangeRequest, Thread.currentThread().getName());
        DataChangeEvent event = new DataChangeEvent(this);
        event.setChangeType(dataChangeRequest.getChangeType());
        event.setTable(dataChangeRequest.getTable());
        event.setMessageId(dataChangeRequest.getMessageId());

        DefaultFuture defaultFuture = DefaultFuture.newFuture(dataChangeRequest, customApplicationContextAware.getTaskCount(), 6000 * 10);

        applicationContext.publishEvent(event);

        Boolean result = defaultFuture.get();
        log.info("MessageId {} 处理结果 {}", dataChangeRequest.getMessageId(), result);

        if (!result) {
            throw new RuntimeException("处理失败,不进行消息ACK,等待下次重试");
        }
    }

}