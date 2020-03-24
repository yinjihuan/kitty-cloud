package com.cxytiandi.kittycloud.search.biz.param;

import lombok.Data;

import java.io.Serializable;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-10 23:47
 */
@Data
public class ArticleIndexSearchParam implements Serializable {

    /**
     * 搜索词
     */
    private String keyword;

    /**
     * 类型
     */
    private int type;

    /**
     * 标签
     */
    private String tag;

    /**
     * 页数
     */
    private int page;

    /**
     * 页大小
     */
    private int pageSize;

}