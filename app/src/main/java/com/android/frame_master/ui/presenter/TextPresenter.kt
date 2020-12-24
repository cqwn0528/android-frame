package com.android.frame_master.ui.presenter

import com.frame.basic_library.base.mvp.BaseMvpPresenter
import com.android.frame_master.ui.bean.TextBean
import com.android.frame_master.ui.contract.TextContract
import com.android.frame_master.ui.contract.TextContract.View
import com.android.frame_master.ui.model.TextModel
import com.frame.basic_library.data.net.HttpCallback

class TextPresenter : BaseMvpPresenter<View?>(), TextContract.Presenter {

    private var model: TextContract.Model = TextModel()

    override fun checkData(username: String?, pwd: String?) {
        loginRequest()
    }

    private fun loginRequest() {
        mView!!.showLoading()
        model.login(object : HttpCallback<TextBean>() {
            override fun onSuccess(response: TextBean) {
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