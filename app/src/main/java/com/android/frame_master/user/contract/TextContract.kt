package com.android.frame_master.user.contract

import com.frame.basic_library.base.mvp.BaseMvpView
import com.android.frame_master.bean.UserBean
import com.frame.basic_library.data.net.HttpCallback

interface TextContract {

    interface Model {
        fun  login(httpCallback: HttpCallback<UserBean>)
    }

    interface View : BaseMvpView {

    }

    interface Presenter {
        fun checkData(username: String?, pwd: String?)
    }
}