package com.cxytiandi.kittycloud.mqconsume.es.controller;

import com.cxytiandi.kittycloud.mqconsume.es.enums.ChangeTypeEnum;
import com.cxytiandi.kittycloud.mqconsume.es.request.DataChangeRequest;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 20:45
 */
@RestController
public class EsMqProduceMockRestController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/message/send")
    public String sendMessage() {
        DataChangeRequest request = new DataChangeRequest();
        request.setMessageId("1");
        request.setMessage("xxx");
        request.setChangeType(ChangeTypeEnum.INSERT.getType());
        rocketMQTemplate.syncSend("data_change", request);
        return "success";
    }

}