package com.android.frame_master.user.presenter

import com.android.frame_master.base.BaseMvpPresenter
import com.android.frame_master.bean.UserBean
import com.android.frame_master.data.net.HttpUtil
import com.android.frame_master.data.net.http.HttpCallback
import com.android.frame_master.user.contract.TextContract
import com.android.frame_master.user.contract.TextContract.View
import com.android.frame_master.user.model.TextModel

class TextPresenter : BaseMvpPresenter<View?>(), TextContract.Presenter {

    private var model: TextContract.Model = TextModel()

    override fun checkData(username: String?, pwd: String?) {
        login()
    }

    private fun login() {
        mView!!.showLoading()
        HttpUtil.getRequest("https://www.baidu.com", object : HttpCallback<UserBean>() {
            override fun onSuccess(response: UserBean) {
            }

            override fun onError(msg: String) {
            }

            override fun onFail() {

            }
        }, UserBean::class.java)
    }
}