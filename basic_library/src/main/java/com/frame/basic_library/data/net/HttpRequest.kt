package com.frame.basic_library.data.net

import android.os.Handler
import android.os.Looper
import com.frame.basic_library.base.basic.BasicBean
import com.google.gson.Gson
import okhttp3.*
import okio.IOException

object HttpRequest {

    val mHttpHandle = Handler(Looper.getMainLooper())

    /**
     * 发送get 请求
     */
    fun <T : BasicBean> get(url: String, httpCallback: HttpCallback<T>, clazz: Class<T>) {
        HttpIClient.okHttpClient.newCall(
            HttpIClient.requestBuild.get().url(url).build()
        )
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    e.printStackTrace()
                    httpCallback.onFail()
                }

                override fun onResponse(call: Call, response: Response) {
                    mHttpHandle.post {
                        response.use {
                            if (response.isSuccessful) {

                                when (response.code) {
                                    200 -> {
                                        httpCallback.onSuccess(
                                            Gson().fromJson(
                                                response.body!!.string(),
                                                clazz
                                            )
                                        )
                                    }
                                    201 -> {
                                    }
                                    400 -> {
                                    }
                                    401 -> {
                                    }
                                    else -> {
                                    }
                                }
                            } else {
                                httpCallback.onError(response.message)
                            }
                        }
                    }
                }
            })
    }

    /**
     * 发送post 请求
     */
    fun <T : BasicBean> post(
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
            HttpIClient.requestBuild.post(requestBody).url(url).build()
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
                                    httpCallback.onSuccess(
                                        Gson().fromJson(
                                            response.body!!.string(),
                                            clazz
                                        )
                                    )
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


