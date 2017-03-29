package com.catpaw.plugins.uploader

import com.catpaw.plugins.extensions.PgyerExtension
import com.catpaw.plugins.utils.UploaderUtils
import org.gradle.api.GradleException

/**
 * Created by congtaowang 2017/3/27.
 */

class PgyerUploader implements Uploader<PgyerExtension> {

    @Override
    void upload(PgyerExtension obj) {

        UploaderUtils.checkPgyerConfig(obj)
        if (obj.forTest) {
            println 'Check only.'
            return
        }
        try {
            def pgyResponse = UploaderUtils.pgyerUpload(obj)
            println "${obj.file.name} upload file done."
            println "Download in -> ${pgyResponse.data.appQRCodeURL}"
        } catch (Exception e) {
            throw new GradleException("upload file ${obj.file.name} failed caused by ${e}.")
        }
    }
}
