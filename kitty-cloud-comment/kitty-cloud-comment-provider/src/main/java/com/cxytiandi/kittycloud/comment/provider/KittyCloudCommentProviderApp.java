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
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@EnableSwagger2Doc
@EnableDiscoveryClient
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.cxytiandi.kittycloud.comment.biz.manager")
@SpringBootApplication(scanBasePackages = {"com.cxytiandi.kittycloud.comment","com.cxytiandi.kitty.web.config"})
public class KittyCloudCommentProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(KittyCloudCommentProviderApp.class);
    }
}