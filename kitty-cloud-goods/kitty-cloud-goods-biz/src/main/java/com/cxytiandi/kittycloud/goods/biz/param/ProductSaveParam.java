package com.cxytiandi.kittycloud.goods.biz.param;

import com.cxytiandi.kittycloud.goods.biz.document.AttrDocument;
import com.cxytiandi.kittycloud.goods.biz.document.SkuDocument;

import java.util.List;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-07-24 22:14
 */
public class ProductSaveParam {

    /**
     * 名称
     */
    private String name;

    /**
     * 状态
     */
    private int status;

    /**
     * 业务类型
     */
    private int bizType;

    /**
     * 客户
     */
    private String customer;

    /**
     * 属性
     */
    private List<AttrDocument> attrs;

    /**
     * SKU
     */
    private List<SkuDocument> skus;

}
