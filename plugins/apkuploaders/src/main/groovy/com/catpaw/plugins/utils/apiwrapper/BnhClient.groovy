package com.catpaw.plugins.utils.apiwrapper

import com.catpaw.plugins.extensions.BnhExtension
import com.catpaw.plugins.uploader.entity.BnhResponse
import com.catpaw.plugins.utils.UploaderUtils;

/**
 * Created by congtaowang 2017/3/28.
 */

public class BnhClient implements Client<BnhExtension, BnhResponse> {

    @Override
    BnhResponse request(BodyWrapper<BnhExtension> wrapper, BnhExtension obj) {

        def client = UploaderUtils.defaultClient()
        def request = wrapper.wrapper(obj)

        def response = client.newCall(request).execute()

        //TODO add response logic.
        return null
    }
}
