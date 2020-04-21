package com.cxytiandi.kittycloud.aggregation.autoconfigure;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * Bean 自动配置
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-04-14 23:09
 */
@Configuration
public class BeanAutoconfigure {

    /**
     * 负载均衡（可以根据服务名调用）
     * @return
     */
    @Bean("loadBalanceRestTemplate")
    @Primary
    @LoadBalanced
    public RestTemplate loadBalanceRestTemplate() {
        return new RestTemplate();
    }

    /**
     * 普通调用（必须有IP）
     * @return
     */
    @Bean("restTemplate")
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}