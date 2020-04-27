package com.cxytiandi.kittycloud.mqconsume.es.request;

import lombok.Data;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 20:26
 */
@Data
public class DataChangeRequest {

    private String table;

    private int changeType;

    private String message;

    private String messageId;

}