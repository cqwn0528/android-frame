package com.android.frame_master.util

import com.frame.basic_library.data.`fun`.ToastFun

object ToastUtil {
    /**
     * ToastUtils toast 弹框方法
     */
    fun showToast(msg: String) = ToastFun.showToastMsg(CtxUtil.getAplContext(), msg)
}

