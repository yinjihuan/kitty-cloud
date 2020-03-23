package com.cxytiandi.kittycloud.search.biz.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ES 索引配置
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 21:18
 */
@Data
@Configuration
@ConfigurationProperties("kitty.cloud.search.es")
public class ElasticSearchIndexConfig {

    /**
     * 文章搜索索引名（搜索和保存分开，方便重建索引）
     */
    private String articleSearchIndexName;

    /**
     * 文章保存索引名（搜索和保存分开，方便重建索引）
     */
    private String articleSaveIndexName;

}