package com.android.frame_master.net.http

abstract class HttpCallback<T> {
    abstract fun onSuccess(response: T)
    abstract fun onError(msg: String)
    abstract fun onFail()
}