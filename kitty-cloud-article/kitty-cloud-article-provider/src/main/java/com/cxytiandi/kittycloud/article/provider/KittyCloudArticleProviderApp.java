package com.cxytiandi.kittycloud.article.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 文章服务启动类
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
@EnableDiscoveryClient
@SpringBootApplication
public class KittyCloudArticleProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(KittyCloudArticleProviderApp.class);
    }
}