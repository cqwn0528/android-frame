package com.frame.basic_library.data.`fun`

import android.content.Context
import android.widget.Toast
import kotlinx.coroutines.*

/**
 * ToastUtils 解决Toast重复弹出的问题
 */
object ToastFun {
    private var toast: Toast? = null
    private var toastStr = ""
    private val uiScope = CoroutineScope(Dispatchers.Main)

    //Toast弹框
    fun showToastMsg(ctx: Context, msg: String) {
        if (msg.isEmpty() || toastStr == msg) {
            return
        } else {
            if (toast != null) {
                toast!!.cancel()
                uiScope.cancel()
            }
        }
        /* 根据文档规范 Android R 以上不再支持该方法 以及 自定义View
         if (Build.VERSION.SDK_INT < Build.VERSION_CODES.R) {
           toast!!.setGravity(Gravity.CENTER, 0, 0)
         }*/
        toastStr = msg
        toast = Toast.makeText(ctx, msg, Toast.LENGTH_SHORT)
        toast!!.setText(msg)
        toast!!.show()
        uiScope.launch {
            delay(2_000)
            toastStr = ""
            toast!!.cancel()
        }
    }
}