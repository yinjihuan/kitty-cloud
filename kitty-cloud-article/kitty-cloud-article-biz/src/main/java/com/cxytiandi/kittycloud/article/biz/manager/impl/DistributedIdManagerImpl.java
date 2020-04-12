package com.cxytiandi.kittycloud.article.biz.manager.impl;

import com.cxytiandi.kitty.id.service.DistributedIdLeafSnowflakeRemoteService;
import com.cxytiandi.kittycloud.article.biz.manager.DistributedIdManager;
import com.cxytiandi.kittycloud.common.constant.DubboConstant;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 分布式ID Manager接口实现
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
@Component
public class DistributedIdManagerImpl implements DistributedIdManager {

    @Value("${spring.application.name}")
    private String applicationName;

    @Reference(version = DubboConstant.VERSION_V100, group = DubboConstant.DEFAULT_GROUP, check = false)
    private DistributedIdLeafSnowflakeRemoteService distributedIdLeafSnowflakeRemoteService;

    @Override
    public String getDistributedId() {
        String snowflakeId = distributedIdLeafSnowflakeRemoteService.getSnowflakeId(applicationName);
        return snowflakeId;
    }

}