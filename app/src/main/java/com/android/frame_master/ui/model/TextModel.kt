package com.android.frame_master.ui.model

import com.android.frame_master.ui.bean.TextBean
import com.android.frame_master.ui.contract.TextContract
import com.android.frame_master.util.HttpUtil
import com.frame.basic_library.data.net.HttpCallback

class TextModel : TextContract.Model {

    //登录
    override fun login(httpCallback: HttpCallback<TextBean>) {
        HttpUtil.getRequest("https://www.baidu.com", httpCallback, TextBean::class.java)
    }
}