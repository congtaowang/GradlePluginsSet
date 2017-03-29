package com.catpaw.plugins.uploader.entity;

/**
 * Created by congtaowang 2017/3/27.
 */

public class PgyerEntity {

    def String appKey
    def String userKey
    def String appType
    def String appIsFirst
    def String appIsLastest
    def String appFileSize
    def String appName
    def String appVersion
    def String appVersionNo
    def String appBuildVersion
    def String appIdentifier
    def String appIcon
    def String appDescription
    def String appUpdateDescription
    def String appScreenShots
    def String appShortcutUrl
    def String appQRCodeURL
    def String appCreated
    def String appUpdate


    @Override
    public String toString() {
        return "appKey -> " + appKey + '\n' +
                ", userKey -> " + userKey + '\n' +
                ", appType -> " + appType + '\n' +
                ", appIsFirst -> " + appIsFirst + '\n' +
                ", appIsLastest -> " + appIsLastest + '\n' +
                ", appFileSize -> " + appFileSize + '\n' +
                ", appName -> " + appName + '\n' +
                ", appVersion -> " + appVersion + '\n' +
                ", appVersionNo -> " + appVersionNo + '\n' +
                ", appBuildVersion -> " + appBuildVersion + '\n' +
                ", appIdentifier -> " + appIdentifier + '\n' +
                ", appIcon -> " + appIcon + '\n' +
                ", appDescription -> " + appDescription + '\n' +
                ", appUpdateDescription -> " + appUpdateDescription + '\n' +
                ", appScreenShots -> " + appScreenShots + '\n' +
                ", appShortcutUrl -> " + appShortcutUrl + '\n' +
                ", appQRCodeURL -> " + appQRCodeURL + '\n' +
                ", appCreated -> " + appCreated + '\n' +
                ", appUpdate -> " + appUpdate + '\n';
    }
}
