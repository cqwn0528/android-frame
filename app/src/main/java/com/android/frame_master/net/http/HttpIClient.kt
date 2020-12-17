package com.android.frame_master.net.http

import okhttp3.*
import java.util.concurrent.TimeUnit


object HttpIClient {

    var okHttpClient: OkHttpClient = OkHttpClient().newBuilder().apply {
        connectTimeout(15, TimeUnit.SECONDS)//设置连接超时时间
        readTimeout(10, TimeUnit.SECONDS)//设置读取超时时间
        writeTimeout(10, TimeUnit.SECONDS)//设置写入超时时间
        callTimeout(10, TimeUnit.SECONDS)
        addInterceptor(HttpInterceptor())//拦截器
    }.build()

    var requestBuild: Request.Builder = Request.Builder().apply {
        header("1", "1")
    }
}


