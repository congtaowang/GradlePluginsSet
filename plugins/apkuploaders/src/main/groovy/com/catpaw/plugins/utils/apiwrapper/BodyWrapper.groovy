package com.catpaw.plugins.utils.apiwrapper

import com.squareup.okhttp.Request;

/**
 * Created by congtaowang 2017/3/28.
 */

public interface BodyWrapper<T> {

    Request wrapper(T t);
}
