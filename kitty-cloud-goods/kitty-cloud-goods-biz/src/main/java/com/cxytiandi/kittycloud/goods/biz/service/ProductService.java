package com.cxytiandi.kittycloud.goods.biz.service;

import com.cxytiandi.kittycloud.goods.biz.param.ProductSaveParam;
import com.cxytiandi.kittycloud.goods.biz.param.ProductUpdateParam;

/**
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-07-24 21:40
 */
public interface ProductService {

    String saveProduct(ProductSaveParam param);

    String saveProductBySpu(String spuId, ProductSaveParam param);

    void updateProduct(ProductUpdateParam param);

    void removeProduct(String id);

}
