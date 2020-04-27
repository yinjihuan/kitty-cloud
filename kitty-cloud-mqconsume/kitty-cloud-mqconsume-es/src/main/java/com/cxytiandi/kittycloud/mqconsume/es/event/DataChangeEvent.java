package com.cxytiandi.kittycloud.mqconsume.es.event;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 20:26
 */
@Data
public class DataChangeEvent extends ApplicationEvent {

    private String table;

    private int changeType;

    private String messageId;

    private String message;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public DataChangeEvent(Object source) {
        super(source);
    }
}