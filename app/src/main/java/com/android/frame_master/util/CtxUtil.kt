package com.android.frame_master.util

import android.content.Context
import com.android.frame_master.application.MyApplication

object CtxUtil {
    /**
     * Application 上下文
     */
    fun getAplContext(): Context = MyApplication.instance.applicationContext
}

