package com.cxytiandi.kittycloud.article.provider;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 文章服务启动类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@EnableSwagger2Doc
@MapperScan("com.cxytiandi.kittycloud.article.biz.mapper")
@EnableDiscoveryClient
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.cxytiandi.kittycloud.article.biz.manager")
@SpringBootApplication(scanBasePackages = {"com.cxytiandi.kittycloud.article","com.cxytiandi.kitty.web.config"})
public class KittyCloudArticleProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(KittyCloudArticleProviderApp.class);
    }
}