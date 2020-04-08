package com.cxytiandi.kittycloud.gateway.web;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Web网关启动类
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-17 20:01:04
 */
@EnableZuulProxy
@EnableCreateCacheAnnotation
@EnableDiscoveryClient
@SpringBootApplication
public class KittyCloudWebGatewayApp {
    public static void main(String[] args) {
        SpringApplication.run(KittyCloudWebGatewayApp.class);
    }

}