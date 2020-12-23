package com.android.frame_master.util

import android.widget.EditText
import android.widget.ImageView
import com.android.frame_master.R
import com.frame.basic_library.data.`fun`.EdtFun
import com.frame.basic_library.data.`fun`.PicFun

/**
 * Edit 明文/密文 显示密码 TODO 需要配置图片ID
 */

object PicUtil{
    fun hintPwd(comparedImg: ImageView, editText: EditText) {
        //配置明文图片ID
        if (PicFun.comparedImg(CtxUtil.getAplContext(),comparedImg, R.drawable.ic_launcher_background)) {
            //配置密文图片ID
            comparedImg.setImageResource(R.drawable.ic_launcher_background)
            EdtFun.hindPwd(editText)
        } else {
            //配置明文图片ID
            comparedImg.setImageResource(R.drawable.ic_launcher_background)
            EdtFun.showPwd(editText)
        }
    }
}

