package com.catpaw.plugins.utils.apiwrapper

import com.catpaw.plugins.extensions.PgyerExtension
import com.catpaw.plugins.uploader.entity.PgyerResponse
import com.catpaw.plugins.utils.UploaderUtils
import com.google.gson.Gson

/**
 * Created by congtaowang 2017/3/28.
 */

public class PgyClient implements Client<PgyerExtension, PgyerResponse> {

    @Override
    PgyerResponse request(BodyWrapper<PgyerExtension> wrapper, PgyerExtension obj) {

        def client = UploaderUtils.defaultClient()
        def request = wrapper.wrapper(pgyer)

        def response = client.newCall(request).execute()
        if (response == null || response.body() == null) {
            return null
        }

        def is = response.body().byteStream()
        def sb = new StringBuilder()
        def br = new BufferedReader(new InputStreamReader(is))
        def line = ""
        while ((line = br.readLine()) != null) {
            sb.append(line)
        }

        def pgyResponse = new Gson().fromJson(result, PgyerResponse.class)
        return pgyResponse
    }
}
