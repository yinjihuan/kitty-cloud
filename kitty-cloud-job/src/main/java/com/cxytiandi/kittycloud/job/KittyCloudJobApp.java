package com.cxytiandi.kittycloud.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Job启动类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-11 21:09
 */
@SpringBootApplication(scanBasePackages = {"com.cxytiandi.kittycloud.job","com.cxytiandi.kitty.web.config"})
public class KittyCloudJobApp {

    public static void main(String[] args) {
        SpringApplication.run(KittyCloudJobApp.class);
    }

}