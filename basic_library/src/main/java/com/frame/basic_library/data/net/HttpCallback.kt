package com.frame.basic_library.data.net

abstract class HttpCallback<T> {
    abstract fun onSuccess(response: T)
    abstract fun onError(msg: String)
    abstract fun onFail()
}