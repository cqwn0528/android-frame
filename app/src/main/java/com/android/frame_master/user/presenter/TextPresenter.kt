package com.android.frame_master.user.presenter

import com.frame.basic_library.base.mvp.BaseMvpPresenter
import com.android.frame_master.bean.UserBean
import com.android.frame_master.user.contract.TextContract
import com.android.frame_master.user.contract.TextContract.View
import com.android.frame_master.user.model.TextModel
import com.frame.basic_library.data.net.HttpCallback

class TextPresenter : BaseMvpPresenter<View?>(), TextContract.Presenter {

    private var model: TextContract.Model = TextModel()

    override fun checkData(username: String?, pwd: String?) {
        loginRequest()
    }

    private fun loginRequest() {
        mView!!.showLoading()
        model.login(object : HttpCallback<UserBean>() {
            override fun onSuccess(response: UserBean) {
                mView!!.hideLoading()
            }

            override fun onError(msg: String) {
                mView!!.hideLoading()
            }

            override fun onFail() {
                mView!!.hideLoading()
            }
        })
    }
}