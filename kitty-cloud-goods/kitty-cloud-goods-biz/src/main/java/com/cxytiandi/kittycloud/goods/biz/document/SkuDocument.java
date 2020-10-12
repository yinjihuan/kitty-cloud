package com.cxytiandi.kittycloud.goods.biz.document;

import java.math.BigDecimal;
import java.util.List;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-07-24 21:25
 */
public class SkuDocument {

    private String id;

    private String name;

    private BigDecimal price;

    private List<SaleAttrValueDocument> saleAttrValues;

}
