package com.catpaw.plugins.extensions;

/**
 * Created by congtaowang 2017/3/27.
 */

public class BnhExtension {

    def boolean isOpen = false
    def File file
    def String tag = 'baonahao'

    @Override
    public String toString() {
        return "BnhExtension{" +
                "isOpen=" + isOpen +
                ", file=" + file +
                ", tag='" + tag + '\'' +
                '}';
    }
}
