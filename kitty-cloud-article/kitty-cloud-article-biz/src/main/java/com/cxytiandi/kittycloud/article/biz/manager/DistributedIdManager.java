package com.cxytiandi.kittycloud.article.biz.manager;

/**
 * 分布式ID Manager接口
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-12 20:01:04
 */
public interface DistributedIdManager {

    /**
     * 获取分布式ID
     * @return
     */
    String getDistributedId();

}