package com.android.frame_master.application

import com.frame.basic_library.base.basic.BasicApplication
import kotlin.properties.Delegates

class MyApplication : BasicApplication() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
       lateinit var instance: MyApplication
    }
}