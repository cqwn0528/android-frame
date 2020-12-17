package com.android.frame_master.net.http

import android.util.Log
import com.android.frame_master.bean.BaseBean
import com.android.frame_master.net.HttpUrl
import com.google.gson.Gson
import okhttp3.*
import okio.IOException

object HttpRequest {
    /**
     * 发送get 请求
     */
    fun <T : BaseBean> get(
        url: String,
        httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) {

        HttpIClient.okHttpClient.newCall(
            HttpIClient.requestBuild.get().url(HttpUrl.hostUrl + url).build()
        )
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                    httpCallback.onFail()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        if (response.isSuccessful) {
                            when (response.code) {
                                200 -> {
                                    /* val bean =
                                         Gson().fromJson(response.body!!.string(), clazz)
                                     httpCallback.onSuccess(bean)*/

                                    Log.e("我是", "200")
                                }
                                201 -> {
                                    Log.e("我是", "201")
                                }
                                400 -> {
                                    Log.e("我是", "400")
                                }
                                401 -> {
                                    Log.e("我是", "401")
                                }
                                else -> {
                                    Log.e("我是", "未知错误")
                                }
                            }
                        } else {
                            httpCallback.onError(response.message)
                        }
                    }
                }
            })
    }

    /**
     * 发送post 请求
     */
    fun <T : BaseBean> post(
        requestType: Int, params: Any, url: String, httpCallback: HttpCallback<T>, clazz: Class<T>
    ) {
        val requestBody: RequestBody = when (requestType) {
            HttpConstant.HTTP_BODY_TYPE_FORM -> {
                HttpReqBody.formRequestBody(params as MutableMap<*, *>)
            }
            HttpConstant.HTTP_BODY_TYPE_JSON -> {
                HttpReqBody.jsonRequestBody(params as String)
            }
            HttpConstant.HTTP_BODY_TYPE_FILE -> {
                HttpReqBody.fileRequestBody(params as String)
            }
            else -> {
                return
            }
        }

        HttpIClient.okHttpClient.newCall(
            HttpIClient.requestBuild.post(requestBody).url(HttpUrl.hostUrl + url).build()
        )
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                    httpCallback.onFail()
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        if (response.isSuccessful) {
                            when (response.code) {
                                200 -> {
                                    val bean =
                                        Gson().fromJson(response.body!!.string(), clazz)
                                    httpCallback.onSuccess(bean)
                                }
                                201 -> {

                                }
                                400 -> {

                                }
                                401 -> {

                                }
                                else -> {
                                    //参数未知错误
                                }
                            }
                        } else {
                            httpCallback.onError(response.message)
                        }
                    }
                }
            })
    }
}


