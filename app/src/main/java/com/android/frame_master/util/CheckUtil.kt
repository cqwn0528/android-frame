package com.android.frame_master.util

import android.widget.EditText
import com.frame.basic_library.data.`fun`.RegularFun
import com.frame.basic_library.data.`fun`.StringFun

object CheckUtil {
    /**
     * 校验EdtText 是否为空 true为空 false非空
     */
    fun checkIsEdtEmpty(edt: EditText, toastStr: String): Boolean {
        if (StringFun.strIsEmpty(edt.text.toString())) {
            ToastUtil.showToast(toastStr)
            return true
        }
        return false
    }

    /**
     * 校验 手机号 true 不合规 false 合规
     */
    fun checkMobileNonCompliant(phoneStr: String, toastStr: String): Boolean {
        if (!RegularFun.isMobileNum(phoneStr)) {
            ToastUtil.showToast(toastStr)
            return true
        }
        return false
    }

    /**
     * 校验 身份证 true 不合规 false 合规
     */
    fun checkIdCardNonCompliant(idStr: String, toastStr: String): Boolean {
        if (!RegularFun.isIdCardNum(idStr)) {
            ToastUtil.showToast(toastStr)
            return true
        }
        return false
    }

    /**
     * 校验 密码 true 不合规 false 合规
     */
    fun checkPwdNonCompliant(pwdStr: String, toastStr: String): Boolean {
        if (!RegularFun.isMobileNum(pwdStr)) {
            ToastUtil.showToast(toastStr)
            return true
        }
        return false
    }
}

