package com.catpaw.plugins.tasks

import com.catpaw.plugins.extensions.BnhExtension
import com.catpaw.plugins.uploader.BnhUploader
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

/**
 * Created by congtaowang 2017/3/28.
 */

class BnhUploaderTask extends UploaderTask {

    @TaskAction
    def upload() {

        final BnhExtension bnh = project.apkUploaderConfigurator.bnhInst

        File file = project.apkUploaderConfigurator.archiveDirectory
        if (!file.isDirectory()) {
            throw new GradleException('archiveDirectory property must be directory.')
        }

        def apks = []
        file.listFiles(new FilenameFilter() {
            @Override
            boolean accept(File f, String s) {
                return s.contains(bnh.tag)
            }
        }).each {
            apks.add(it)
        }

        if (apks.size() != 1) {
            throw new GradleException('Only one apk can upload one time.')
        }
        bnh.file = apks.get(0)

        super.upload(new BnhUploader(), bnh)
    }
}
