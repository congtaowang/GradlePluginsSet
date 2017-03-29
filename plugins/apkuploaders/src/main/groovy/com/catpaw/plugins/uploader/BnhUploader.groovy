package com.catpaw.plugins.uploader

import com.catpaw.plugins.extensions.BnhExtension
import com.catpaw.plugins.utils.UploaderUtils
import org.gradle.api.GradleException
/**
 * Created by congtaowang 2017/3/27.
 */

class BnhUploader implements Uploader<BnhExtension> {

    @Override
    void upload(BnhExtension obj) {

        print obj
        UploaderUtils.checkBnhConfig(obj)
        if (!obj.isOpen) {
            println 'bnh uploader check done, just return.'
            return
        }
        try {
            def response = UploaderUtils.bnhUpload(obj)
            println "${obj.file.name} uploaded."
        } catch (Exception e) {
            throw new GradleException("upload file ${obj.file.name} failed caused by ${e}.")
        }
    }
}
