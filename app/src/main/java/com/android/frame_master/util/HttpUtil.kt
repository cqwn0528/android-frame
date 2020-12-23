package com.android.frame_master.util

import com.frame.basic_library.base.basic.BasicBean
import com.frame.basic_library.data.net.HttpCallback
import com.frame.basic_library.data.net.HttpConstant
import com.frame.basic_library.data.net.HttpRequest

object HttpUtil {
    /**
     * get 请求
     */
    fun <T : BasicBean> getRequest(url: String, httpCallback: HttpCallback<T>, clazz: Class<T>) =
        HttpRequest.get(url, httpCallback, clazz)

    /**
     * post json提交
     */
    fun <T : BasicBean> postJsonRequest(
        url: String,
        params: String,
        httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) = HttpRequest.post(
        HttpConstant.HTTP_BODY_TYPE_JSON,
        params,
        url,
        httpCallback,
        clazz
    )

    /**
     * post 表单提交
     */
    fun <T : BasicBean> postFormRequest(
        url: String,
        params: MutableMap<*, *>,
        httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) =
        HttpRequest.post(
            HttpConstant.HTTP_BODY_TYPE_FORM,
            params,
            url,
            httpCallback,
            clazz
        )


    /**
     * post 文件提交
     */
    fun <T : BasicBean> upFileRequest(
        url: String,
        path: String,
        httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) =
        HttpRequest.post(HttpConstant.HTTP_BODY_TYPE_FILE, path, url, httpCallback, clazz)
}


