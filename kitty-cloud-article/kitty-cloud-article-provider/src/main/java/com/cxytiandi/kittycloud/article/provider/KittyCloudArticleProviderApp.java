package com.cxytiandi.kittycloud.article.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 文章服务启动类ArticleService
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
@MapperScan("com.cxytiandi.kittycloud.article.biz.dao")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.cxytiandi"})
public class KittyCloudArticleProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(KittyCloudArticleProviderApp.class);
    }
}