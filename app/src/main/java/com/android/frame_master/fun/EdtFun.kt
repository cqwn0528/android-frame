package com.android.frame_master.`fun`

import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.text.method.TransformationMethod
import android.widget.EditText


/**
 * 控制密码显示隐藏
 */
object EdtFun {
    //隐藏密码
    fun hindPwd(editText: EditText) {
        //设置密码明文
        val method: TransformationMethod = PasswordTransformationMethod.getInstance()
        editText.transformationMethod = method
        val edtStr = editText.text.toString()
        editText.setSelection(edtStr.length)
    }

    //显示密码
    fun showPwd(editText: EditText) {
        //设置密码密文
        val method = HideReturnsTransformationMethod.getInstance()
        editText.transformationMethod = method
        val edtStr = editText.text.toString()
        editText.setSelection(edtStr.length)
    }
}