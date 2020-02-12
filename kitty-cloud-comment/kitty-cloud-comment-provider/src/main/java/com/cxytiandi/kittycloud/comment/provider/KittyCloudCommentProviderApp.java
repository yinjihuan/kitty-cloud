package com.cxytiandi.kittycloud.comment.provider;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 评论服务启动类
 *
 * @author yinjihuan
 *
 * @about http://cxytiandi.com/about
 *
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.cxytiandi.kittycloud.comment.biz.manager")
@SpringBootApplication(scanBasePackages = {"com.cxytiandi"})
public class KittyCloudCommentProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(KittyCloudCommentProviderApp.class);
    }
}