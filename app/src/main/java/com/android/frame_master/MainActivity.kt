package com.android.frame_master

import com.android.frame_master.util.CtxUtil
import com.android.frame_master.util.ShareUtil
import com.frame.basic_library.base.basic.BasicActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * app 初始类
 */
class MainActivity : BasicActivity() {

    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
    }

    override fun initData() {
        GlobalScope.launch {
            //share 初始化
            ShareUtil.initShare(CtxUtil.getAplContext())
        }
    }
}