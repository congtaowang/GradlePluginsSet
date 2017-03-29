package com.catpaw.plugins.utils.apiwrapper

import com.catpaw.plugins.extensions.PgyerExtension
import com.squareup.okhttp.MediaType
import com.squareup.okhttp.MultipartBuilder
import com.squareup.okhttp.Request
import com.squareup.okhttp.RequestBody
import org.gradle.api.GradleException;

/**
 * Created by congtaowang 2017/3/28.
 */

public class PgyerWrapper implements BodyWrapper<PgyerExtension> {

    @Override
    Request wrapper(PgyerExtension pgyerExtension) {

        def mb = new MultipartBuilder()
                .type(MultipartBuilder.FORM)

        if (mb == null) {
            throw new GradleException("create request body fail.")
        }

        mb.addFormDataPart("_api_key", pgyer._api_key)
        mb.addFormDataPart("uKey", pgyer.uKey)
        if (pgyer.installType != null)
            mb.addFormDataPart("installType", pgyer.installType)
        if (pgyer.password != null)
            mb.addFormDataPart("password", pgyer.password)
        if (pgyer.updateDescription != null)
            mb.addFormDataPart("updateDescription", pgyer.updateDescription)

        mb.addFormDataPart("file",
                pgyer.file.name,
                RequestBody.create(
                        MediaType.parse("application/vnd.android.package-archive"),
                        pgyer.file)
        )
        def builder = new Request.Builder()

        if (builder == null) {
            throw new GradleException("create request instance builder fail.")
        }

        builder.url('https://qiniu-storage.pgyer.com/apiv1/app/upload')
                .post(mb.build())

        return builder.build()
    }
}
