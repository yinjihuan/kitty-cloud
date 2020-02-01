package com.cxytiandi.kittycloud.article.provider;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
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
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.cxytiandi.kittycloud.article.biz.manager")
@SpringBootApplication(scanBasePackages = {"com.cxytiandi"})
public class KittyCloudArticleProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(KittyCloudArticleProviderApp.class);
    }
}