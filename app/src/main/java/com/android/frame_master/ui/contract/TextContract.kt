package com.android.frame_master.ui.contract

import com.android.frame_master.ui.bean.TextBean
import com.frame.basic_library.base.mvp.BaseMvpView
import com.frame.basic_library.data.net.HttpCallback

interface TextContract {

    interface Model {
        fun login(httpCallback: HttpCallback<TextBean>)
    }

    interface View : BaseMvpView {
    }

    interface Presenter {
        fun checkData(username: String?, pwd: String?)
    }
}