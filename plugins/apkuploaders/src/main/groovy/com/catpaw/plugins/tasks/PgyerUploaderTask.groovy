package com.catpaw.plugins.tasks

import com.catpaw.plugins.extensions.PgyerExtension
import com.catpaw.plugins.uploader.PgyerUploader
import org.gradle.api.GradleException
import org.gradle.api.tasks.TaskAction

/**
 * Created by congtaowang 2017/3/27.
 */

class PgyerUploaderTask extends UploaderTask {

    @TaskAction
    def upload() {

        final PgyerExtension pgyer = project.apkUploaderConfigurator.pgyerInst

        File file = project.apkUploaderConfigurator.archiveDirectory
        if (!file.isDirectory()) {
            throw new GradleException('archiveDirectory property must be directory.')
        }

        def apks = []
        file.listFiles(new FilenameFilter() {
            @Override
            boolean accept(File f, String s) {
                return s.contains(pgyer.tag)
            }
        }).each {
            apks.add(it)
        }

        if (apks.size() != 1) {
            throw new GradleException('Only one apk can upload one time.')
        }
        pgyer.file = apks.get(0)

        super.upload(new PgyerUploader(), pgyer)
    }
}
