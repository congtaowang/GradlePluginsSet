package com.catpaw.plugins.uploader.entity;

/**
 * Created by congtaowang 2017/3/27.
 */

public class PgyerResponse {

    def String code
    def String message
    def PgyerEntity data


    @Override
    public String toString() {
        return "PgyerResponse{" +
                "code -> " + code + "\n" +
                ", message -> " + message + "\n" +
                ", data -> " + data +
                '}';
    }
}
