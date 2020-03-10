package com.cxytiandi.kittycloud.search.biz.config;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.cxytiandi.kittycloud.common.constant.NacosConstant;
import lombok.Data;
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
@NacosConfigurationProperties(prefix = "kitty.cloud.search.es", dataId = NacosConstant.SEARCH_ES_BIZ, groupId = NacosConstant.BIZ_GROUP, autoRefreshed = true)
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