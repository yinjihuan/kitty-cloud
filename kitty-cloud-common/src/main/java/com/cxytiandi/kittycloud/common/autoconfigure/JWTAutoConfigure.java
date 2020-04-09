package com.cxytiandi.kittycloud.common.autoconfigure;

import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.AbstractListener;
import com.alibaba.nacos.api.exception.NacosException;
import com.cxytiandi.kitty.common.json.JsonUtils;
import com.cxytiandi.kittycloud.common.config.JwtRsaConfig;
import com.cxytiandi.kittycloud.common.constant.NacosConstant;
import com.cxytiandi.kittycloud.common.helper.ApplicationContextHelper;
import com.cxytiandi.kittycloud.common.helper.JWTHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

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
@Slf4j
@Configuration
@ConditionalOnProperty(prefix = "kitty.cloud.jwt.rsa", value = "modulus")
@ImportAutoConfiguration(JwtRsaConfig.class)
public class JWTAutoConfigure {

    @Autowired
    private NacosConfigProperties nacosConfigProperties;

    /**
     * 监听配置修改，spring-cloud-alibaba 2.1.0版本不支持@NacosConfigListener的监听
     */
    @PostConstruct
    public void initConfigUpdateListener() {
        ConfigService configService = nacosConfigProperties.configServiceInstance();
        try {
            configService.addListener(NacosConstant.JWT_RSA_BIZ, NacosConstant.BIZ_GROUP, new AbstractListener() {
                @Override
                public void receiveConfigInfo(String configInfo) {
                    try {
                        Properties properties = new Properties();
                        properties.load(new ByteArrayInputStream(configInfo.getBytes()));
                        JwtRsaConfig jwtRsaConfig = JsonUtils.toBean(JwtRsaConfig.class, JsonUtils.toString(properties));
                        JWTHelper jwtHelper = ApplicationContextHelper.getBean(JWTHelper.class);
                        jwtHelper.reload(jwtRsaConfig.getModulus(), jwtRsaConfig.getPrivateExponent(), jwtRsaConfig.getPublicExponent());
                        log.info("jwt配置有变化，刷新完成");
                    } catch (IOException e2) {
                        log.error("", e2);
                    }
                }
            });
        } catch (NacosException e) {
            log.error("", e);
        }
    }

    @Bean
    public JWTHelper jwtHelper(JwtRsaConfig jwtRsaConfig) {
        return new JWTHelper(jwtRsaConfig);
    }
}