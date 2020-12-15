package com.android.frame_master.net

import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class HttpUtil() {

    private lateinit var okHttpClient: OkHttpClient
    private lateinit var formBody: FormBody
    private lateinit var request: Request

    companion object {
        private var instance: HttpUtil? = null
            get() {
                if (field == null) {
                    field = HttpUtil()
                }
                return field
            }

        fun get(): HttpUtil {
            //细心的小伙伴肯定发现了，这里不用getInstance作为为方法名，是因为在伴生对象声明时，内部已有getInstance方法，所以只能取其他名字
            return instance!!
        }
    }

    init {
        okHttpClient = OkHttpClient()
        formBody = FormBody.Builder().add("code", "1234").build()
        request = Request.Builder().url("").build()
    }



}