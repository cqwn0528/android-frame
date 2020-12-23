package com.android.frame_master.user.view

import com.android.frame_master.R
import com.frame.basic_library.base.mvp.BaseMvpActivity
import com.android.frame_master.user.contract.TextContract
import com.android.frame_master.user.presenter.TextPresenter
import kotlinx.android.synthetic.main.activity_text.*

class TextActivity : BaseMvpActivity<TextPresenter>(), TextContract.View {

    override fun setLayoutId(): Int = R.layout.activity_text


    override fun initView() {}

    override fun initData() {
        mPresenter = TextPresenter()
        mPresenter.attachView(this)
    }

    override fun initListener() {
        btn_text.setOnClickListener {
            mPresenter.checkData("1", "2")
        }
    }

    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}