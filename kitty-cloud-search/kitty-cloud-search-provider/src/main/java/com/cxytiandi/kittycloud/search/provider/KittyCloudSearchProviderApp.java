package com.cxytiandi.kittycloud.search.provider;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 搜索服务启动类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 21:51
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.cxytiandi.kittycloud.search","com.cxytiandi.kitty.web.config"})
public class KittyCloudSearchProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(KittyCloudSearchProviderApp.class);
    }

}