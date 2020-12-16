package com.android.frame_master.net

interface HttpCallback<T> {
    fun onSuccess(response: T)
    fun onError(response: String)
    fun onFail()
}