package com.cxytiandi.kittycloud.common.base;

public interface EntityConvert<S,T> {

    T convert(S source);

}
