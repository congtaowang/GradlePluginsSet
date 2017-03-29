package com.catpaw.plugins.tasks

import com.catpaw.plugins.uploader.Uploader;
import org.gradle.api.DefaultTask;

/**
 * Created by congtaowang 2017/3/27.
 */

class UploaderTask extends DefaultTask {

    def upload(Uploader uploader, Object object) {
        uploader.upload(object)
    }
}
