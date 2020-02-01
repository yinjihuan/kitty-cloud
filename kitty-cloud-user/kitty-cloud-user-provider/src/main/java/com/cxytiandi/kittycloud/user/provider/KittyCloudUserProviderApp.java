package com.cxytiandi.kittycloud.user.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户服务启动类
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
@MapperScan("com.cxytiandi.kittycloud.user.biz.dao")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.cxytiandi"})
public class KittyCloudUserProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(KittyCloudUserProviderApp.class);
    }

}