package com.catpaw.plugins

import com.catpaw.plugins.extensions.Configurator
import org.gradle.api.Plugin
import org.gradle.api.Project

public class ApkuploadersPlugin implements Plugin<Project> {

    @Override
    void apply(Project project) {
        project.extensions.create('apkUploaderConfigurator', Configurator)
    }
}