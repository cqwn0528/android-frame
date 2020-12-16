package com.android.frame_master.net

import android.util.Log
import com.android.frame_master.bean.BaseBean
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okio.IOException
import java.io.File
import java.util.concurrent.TimeUnit


class HttpUtil {

    //instance
    companion object {
        val instance: HttpUtil by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            HttpUtil()
        }
    }

    //http-client
    private var okHttpClient: OkHttpClient = OkHttpClient().newBuilder().apply {
        connectTimeout(15, TimeUnit.SECONDS)//设置连接超时时间
        readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
        writeTimeout(10, TimeUnit.SECONDS)//设置写入超时时间
        callTimeout(10, TimeUnit.SECONDS)
        addInterceptor(HttpInterceptor())//拦截器
    }.build()

    //request-build
    private var requestBuild: Request.Builder = Request.Builder().apply {
        header("1", "1")
    }

    /**
     * get 请求
     */
    fun <T : BaseBean> getRequest(
        url: String,
        httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) {
        okHttpClient.newCall(requestBuild.get().url(url).build()).enqueue(object : Callback {
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
     * post 表单提交
     */
    fun <T : BaseBean> postRequest(
        url: String,
        params: Any,
        httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) {
        lateinit var requestBody: RequestBody
        when (params) {
            is String -> {
                // json提交
                requestBody = params.toRequestBody("application/json;charset=utf-8".toMediaType())
            }
            is MutableMap<*, *> -> {
                //表单提交
                requestBody = FormBody.Builder().apply {
                    for ((key, value) in params) {
                        add(key.toString(), value = value.toString())
                    }
                }.build()
            }
            else -> {
                //无参数类型
                return
            }
        }
        post(requestBody, url, httpCallback, clazz)
    }

    /**
     * post 表单提交
     */
    fun <T : BaseBean> upLoadFile(
        url: String,
        path: String,
        httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) {
        val file = File(path)
        val fileBody = file.asRequestBody("text/x-markdown; charset=utf-8".toMediaType())
        val requestBody =
            MultipartBody.Builder().addFormDataPart("file", file.name, fileBody).build()
        post(requestBody, url, httpCallback, clazz)
    }

    private fun <T : BaseBean> post(
        requestBody: RequestBody, url: String, httpCallback: HttpCallback<T>,
        clazz: Class<T>
    ) {
        okHttpClient.newCall(requestBuild.post(requestBody).url(url).build())
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


