package com.android.frame_master.user.model

import com.android.frame_master.bean.UserBean
import com.android.frame_master.user.contract.TextContract
import com.android.frame_master.util.HttpUtil
import com.frame.basic_library.data.net.HttpCallback

class TextModel : TextContract.Model {

    //登录
    override fun login(httpCallback: HttpCallback<UserBean>) {
        HttpUtil.getRequest("https://www.baidu.com", httpCallback, UserBean::class.java)
    }
}