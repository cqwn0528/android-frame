package com.android.frame_master.util

import android.content.Context
import com.frame.basic_library.data.`fun`.DataStoreFun
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

object ShareUtil {

    //初始化数据
    fun initShare(ctx: Context) {
        DataStoreFun.initDataStore(ctx)
    }

    // 保存数据
    inline fun <reified T : Any> setData(key: String, value: T) {
        GlobalScope.launch {
            DataStoreFun.saveData(key, value)
        }
    }

    // 获取数据
    inline fun <reified T : Any> getData(key: String) {
        GlobalScope.launch {
            DataStoreFun.getData<T>(key)
        }
    }
}
