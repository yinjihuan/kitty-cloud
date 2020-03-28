package com.cxytiandi.kittycloud.common.base;

import lombok.Data;

import java.io.Serializable;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-03-28 13:59
 */
@Data
public class PageEntity implements Serializable {

    /**
     * 页数
     */
    private int page;

    /**
     * 页大小
     */
    private int size;

    /**
     * 排序字段
     */
    private String sortField;

    /**
     * 排序类型（0：升序 1：降序）
     */
    private int sortType;

}