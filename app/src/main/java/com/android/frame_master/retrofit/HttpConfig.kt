package com.android.frame_master.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class HttpConfig {

    //获取Service对象
    fun getApiService(): ApiService = configRetrofit().create(ApiService::class.java)

    //初始化 retrofit
    private fun configRetrofit(): Retrofit =
        Retrofit.Builder().client(configClient()).baseUrl(HttpUrl.baseUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()

    //初始化 client
    private fun configClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)       //连接超时
        .readTimeout(10, TimeUnit.SECONDS)          //读取超时
        .writeTimeout(10, TimeUnit.SECONDS)         //写超时
        .build()
}