package com.android.frame_master.util

import com.android.frame_master.ui.bean.AppInfoBean
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

object AppInfoUtil {

    var token: String = ""
    var isIntoNav: Boolean = false

    fun saveAppInfo() {
        CoroutineScope(Dispatchers.Main).launch {
            val appInfoBean = AppInfoBean()
            appInfoBean.isIntoNav = isIntoNav
            appInfoBean.token = token
            val userInfoStr = Gson().toJson(AppInfoBean())
            PreDataStore.saveData(Constant.APP_INFO, userInfoStr)
        }
    }
}