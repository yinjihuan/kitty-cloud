package com.cxytiandi.kittycloud.user.api.autoconfigure;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * Feign Client自动初始化
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
@EnableFeignClients("com.cxytiandi.kittycloud.user.api")
@ComponentScan("com.cxytiandi.kittycloud.user.api")
public class RemoteServiceAutoConfigure {

}