package com.cxytiandi.kittycloud.mqconsume.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ES MQ消费者启动类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-29 21:09
 */
@EnableAsync
@SpringBootApplication
public class EsMqConsumeApp {

    public static void main(String[] args) {
        SpringApplication.run(EsMqConsumeApp.class);
    }

}