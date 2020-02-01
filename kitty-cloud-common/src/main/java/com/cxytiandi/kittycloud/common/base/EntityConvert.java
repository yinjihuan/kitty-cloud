package com.cxytiandi.kittycloud.common.base;

import java.util.Objects;

public interface EntityConvert<S,T> {

    default T convert(S source) {
        return null;
    }

    default T convertPlus(S source, Objects ...objects) {
        return null;
    }

}
