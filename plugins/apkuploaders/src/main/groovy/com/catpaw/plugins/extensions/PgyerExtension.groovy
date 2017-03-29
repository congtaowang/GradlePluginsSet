package com.catpaw.plugins.extensions;

/**
 * Created by congtaowang 2017/3/27.
 */

class PgyerExtension {

    def boolean forTest

    def String tag = 'pgyer'
    def String uKey
    def String _api_key
    def File file

    /**
     * ( 选填)应用安装方式，值为(1,2,3)。1：公开，2：密码安装，3：邀请安装。默认为1公开
     */
    def String installType
    def String password
    def String updateDescription

    @Override
    public String toString() {
        return "PgyerExtension{" +
                "uKey='" + uKey + '\'' +
                ", _api_key='" + _api_key + '\'' +
                ", file=" + file +
                ", installType='" + installType + '\'' +
                ", password='" + password + '\'' +
                ", updateDescription='" + updateDescription + '\'' +
                '}';
    }
}
