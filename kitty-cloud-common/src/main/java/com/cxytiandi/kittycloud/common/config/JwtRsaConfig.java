package com.cxytiandi.kittycloud.common.config;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-07 22:17
 */
@Data
@Configuration
@ConfigurationProperties("kitty.cloud.jwt.rsa")
public class JwtRsaConfig {

    /**
     * 模
     */
    @JsonAlias("kitty.cloud.jwt.rsa.modulus")
    private String modulus;

    /**
     * 私钥
     */
    @JsonAlias("kitty.cloud.jwt.rsa.privateExponent")
    private String privateExponent;

    /**
     * 公钥
     */
    @JsonAlias("kitty.cloud.jwt.rsa.publicExponent")
    private String publicExponent;

}