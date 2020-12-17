package com.android.frame_master.net

import com.android.frame_master.bean.BaseBean
import com.android.frame_master.net.http.HttpCallback
import com.android.frame_master.net.http.HttpConstant
import com.android.frame_master.net.http.HttpRequest

object HttpUtil {
    /**
     * get 请求
     */
    fun <T : BaseBean> getRequest(url: String, httpCallback: HttpCallback<T>, clazz: Class<T>) =
        HttpRequest.get(url, httpCallback, clazz)

    /**
     * post 表单提交
     */
    fun <T : BaseBean> postJsonRequest(
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

    fun <T : BaseBean> postFormRequest(
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
     * post 表单提交
     */
    fun <T : BaseBean> upFileRequest(
        url: String,
        path: String,
        httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) =
        HttpRequest.post(HttpConstant.HTTP_BODY_TYPE_FILE, path, url, httpCallback, clazz)
}


