package com.android.frame_master.retrofit

import retrofit2.http.GET

interface ApiService {
    @GET("users/JavaNoober/repos")
    suspend fun getUserInfo(): List<UserBean>
}