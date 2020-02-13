package com.cxytiandi.kittycloud.common.base;

import java.util.Objects;

/**
 * 实体转换器
 *
 * @作者 尹吉欢
 * @个人微信 jihuan900
 * @微信公众号 猿天地
 * @GitHub https://github.com/yinjihuan
 * @作者介绍 http://cxytiandi.com/about
 * @时间 2020-02-13 20:44:04
 */
public interface EntityConvert<S,T> {

    default T convert(S source) {
        return null;
    }

    default T convertPlus(S source, Objects ...objects) {
        return null;
    }

}
