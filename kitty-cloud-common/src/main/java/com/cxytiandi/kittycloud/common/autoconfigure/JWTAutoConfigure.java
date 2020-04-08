package com.cxytiandi.kittycloud.common.autoconfigure;

import com.cxytiandi.kittycloud.common.config.JwtRsaConfig;
import com.cxytiandi.kittycloud.common.helper.JWTHelper;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * JWT自动配置
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-08 22:47
 */
@Configuration
@ConditionalOnProperty(prefix = "kitty.cloud.jwt.rsa", value = "modulus")
@ImportAutoConfiguration(JwtRsaConfig.class)
public class JWTAutoConfigure {

    @Bean
    public JWTHelper jwtHelper(JwtRsaConfig jwtRsaConfig) {
        return new JWTHelper(jwtRsaConfig);
    }

}