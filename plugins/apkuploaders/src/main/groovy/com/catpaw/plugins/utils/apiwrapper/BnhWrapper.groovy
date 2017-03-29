package com.catpaw.plugins.utils.apiwrapper

import com.catpaw.plugins.extensions.BnhExtension
import com.squareup.okhttp.MediaType
import com.squareup.okhttp.MultipartBuilder
import com.squareup.okhttp.Request
import com.squareup.okhttp.RequestBody

/**
 * Created by congtaowang 2017/3/28.
 */

public class BnhWrapper implements BodyWrapper<BnhExtension> {

    @Override
    Request wrapper(BnhExtension bnh) {

        def mb = new MultipartBuilder().type(MultipartBuilder.FORM)

        mb.addFormDataPart("file",
                bnh.file.name,
                RequestBody.create(
                        MediaType.parse("application/vnd.android.package-archive"),
                        bnh.file))

        def builder = new Request.Builder()
        builder.url("http://59.110.12.186:9090/").post(mb.build())

        return builder.build()
    }
}
