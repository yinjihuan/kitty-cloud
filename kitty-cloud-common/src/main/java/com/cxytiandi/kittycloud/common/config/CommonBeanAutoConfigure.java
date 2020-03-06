package com.cxytiandi.kittycloud.common.config;

import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.cxytiandi.kittycloud.common.exception.GlobalExceptionHandler;
import com.cxytiandi.kittycloud.common.handler.KittyCloudUrlBlockHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * Common中的自动配置
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-17 20:47
 */
@Configuration
public class CommonBeanAutoConfigure {

    @PostConstruct
    public void init() {
        WebCallbackManager.setUrlBlockHandler(new KittyCloudUrlBlockHandler());
    }

    @Bean
    public GlobalExceptionHandler globalExceptionHandler() {
        return new GlobalExceptionHandler();
    }

}