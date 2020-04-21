package com.cxytiandi.kittycloud.user.provider;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.spring4all.swagger.EnableSwagger2Doc;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 用户服务启动类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@MapperScan("com.cxytiandi.kittycloud.user.biz.mapper")
@EnableDiscoveryClient
@EnableSwagger2Doc
@EnableCreateCacheAnnotation
@EnableMethodCache(basePackages = "com.cxytiandi.kittycloud.user.biz.manager")
@SpringBootApplication(scanBasePackages = {"com.cxytiandi.kittycloud.user","com.cxytiandi.kitty.web.config"})
public class KittyCloudUserProviderApp {

    public static void main(String[] args) {
        SpringApplication.run(KittyCloudUserProviderApp.class);
    }

}