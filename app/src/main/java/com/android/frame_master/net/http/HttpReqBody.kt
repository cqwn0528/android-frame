package com.android.frame_master.net.http

import okhttp3.FormBody
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

object HttpReqBody {

    fun jsonRequestBody(json: String): RequestBody {
        return json.toRequestBody("application/json;charset=utf-8".toMediaType())
    }

    fun formRequestBody(params: MutableMap<*, *>): RequestBody {
        return FormBody.Builder().apply {
            for ((key, value) in params) {
                add(key.toString(), value = value.toString())
            }
        }.build()
    }

    fun fileRequestBody(path: String): RequestBody {
        val file = File(path)
        val fileBody = file.asRequestBody("text/x-markdown; charset=utf-8".toMediaType())
        return MultipartBody.Builder().addFormDataPart("file", file.name, fileBody).build()
    }
}


