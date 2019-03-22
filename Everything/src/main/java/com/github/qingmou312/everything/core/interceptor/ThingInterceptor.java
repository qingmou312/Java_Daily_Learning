package com.github.qingmou312.everything.core.interceptor;

import com.github.qingmou312.everything.core.model.Thing;

/**
 * Author:lidan
 * Created:2019/3/21
 */
@FunctionalInterface
public interface ThingInterceptor {
    void apply(Thing thing);
}
