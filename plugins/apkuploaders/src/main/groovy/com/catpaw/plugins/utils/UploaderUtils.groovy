package com.catpaw.plugins.utils

import com.catpaw.plugins.extensions.BnhExtension
import com.catpaw.plugins.extensions.PgyerExtension
import com.catpaw.plugins.utils.apiwrapper.BnhClient
import com.catpaw.plugins.utils.apiwrapper.BnhWrapper
import com.catpaw.plugins.utils.apiwrapper.PgyClient
import com.catpaw.plugins.utils.apiwrapper.PgyerWrapper
import com.squareup.okhttp.OkHttpClient
import org.gradle.api.GradleException

import java.util.concurrent.TimeUnit

/**
 * Created by congtaowang 2017/3/27.
 */

class UploaderUtils {

    def static defaultClient() {
        return requestClient(60, 10)
    }

    def static requestClient(readTimeOut, connectionTimeOut) {
        def client = new OkHttpClient()
        client.setReadTimeout(readTimeOut, TimeUnit.SECONDS)
        client.setConnectTimeout(connectionTimeOut, TimeUnit.SECONDS)
        return client
    }

    def static checkPgyerConfig(PgyerExtension pgyer) {
        if (pgyer == null) {
            throw new GradleException("can't find pgyer upload configuration.")
        }

        if (pgyer.uKey == null) {
            throw new GradleException('please config uKey of app.')
        }

        if (pgyer._api_key == null) {
            throw new GradleException('please config _api_key of app.')
        }
    }

    def static pgyerUpload(PgyerExtension pgyer) {

        println "uploading file -> ${pgyer.file.absolutePath}"
        def client = new PgyClient()
        def response = client.request(new PgyerWrapper(), pgyer)
        return response
    }

    def static checkBnhConfig(BnhExtension bnh) {
        if (bnh == null) {
            throw new GradleException("plugins internal error.")
        }
        if (bnh.file == null) {
            throw new GradleException("please config bnh uploading files.")
        }
        if (!bnh.file.isFile()) {
            throw new GradleException("${bnh.file.name} is not a available file.")
        }
    }

    def static bnhUpload(BnhExtension bnh) {
        println "uploading file -> ${bnh.file.absoluteFile}"
        def client = new BnhClient()
        def response = client.request(new BnhWrapper(), bnh)
        return response
    }
}
