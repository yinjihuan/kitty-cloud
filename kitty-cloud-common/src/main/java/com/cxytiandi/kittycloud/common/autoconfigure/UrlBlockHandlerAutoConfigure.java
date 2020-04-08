package com.cxytiandi.kittycloud.common.autoconfigure;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlBlockHandler;
import com.alibaba.csp.sentinel.adapter.servlet.callback.WebCallbackManager;
import com.cxytiandi.kittycloud.common.handler.KittyCloudUrlBlockHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-27 22:51
 */
@ConditionalOnClass(UrlBlockHandler.class)
@Configuration
public class UrlBlockHandlerAutoConfigure {

    @PostConstruct
    public void init() {
        WebCallbackManager.setUrlBlockHandler(new KittyCloudUrlBlockHandler());
    }

}