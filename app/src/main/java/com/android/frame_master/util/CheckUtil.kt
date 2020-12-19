package com.android.frame_master.util

import android.widget.EditText
import com.android.frame_master.data.`fun`.RegularFun
import com.android.frame_master.data.`fun`.StringFun

/**
 * 校验EdtText 是否为空 true为空 false非空
 */
fun checkIsEdtEmpty(edt: EditText, toastStr: String): Boolean {
    if (StringFun.strIsEmpty(edt.text.toString())) {
        showToast(toastStr)
        return true
    }
    return false
}

/**
 * 校验 手机号 true 不合规 false 合规
 */
fun checkMobileNonCompliant(phoneStr: String, toastStr: String): Boolean {
    if (!RegularFun.isMobileNum(phoneStr)) {
        showToast(toastStr)
        return true
    }
    return false
}

/**
 * 校验 身份证 true 不合规 false 合规
 */
fun checkIdCardNonCompliant(idStr: String, toastStr: String): Boolean {
    if (!RegularFun.isIdCardNum(idStr)) {
        showToast(toastStr)
        return true
    }
    return false
}

/**
 * 校验 密码 true 不合规 false 合规
 */
fun checkPwdNonCompliant(pwdStr: String, toastStr: String): Boolean {
    if (!RegularFun.isMobileNum(pwdStr)) {
        showToast(toastStr)
        return true
    }
    return false
}