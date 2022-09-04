package com.android.frame_master.util

import android.util.Log

object LogUtil {
    fun error(tag: String, logInfo: String) {
        Log.e(tag, logInfo)
    }

    fun debug(tag: String, logInfo: String) {
        Log.d(tag, logInfo)
    }

    fun info(tag: String, logInfo: String) {
        Log.i(tag, logInfo)
    }

    fun printException(e : Exception) : String? {
        return e.message
    }
}