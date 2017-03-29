package com.catpaw.plugins.utils.apiwrapper;

/**
 * Created by congtaowang 2017/3/28.
 */

public interface Client<T, R> {

    def R request(BodyWrapper<T> wrapper, T obj);
}
