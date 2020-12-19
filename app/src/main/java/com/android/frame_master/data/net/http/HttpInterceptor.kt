package com.android.frame_master.data.net.http

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class HttpInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request: Request = chain.request()
        val t1 = System.nanoTime()

        val response: Response = chain.proceed(request)
        val t2 = System.nanoTime()

        Log.e("网络请求地址", request.url.toString())
        Log.e("网络请求header", request.headers.toString())
        Log.e("网络请求body", request.body.toString())
        Log.e("网络请求方式", request.method)
        Log.e("网络请求时间", ((t2 - t1) / 1e6).toString())
        Log.e("网络请求json", response.body!!.string())

        return response
    }
}