package com.android.frame_master

import android.content.Intent
import com.android.frame_master.ui.activity.ActivityFragment
import com.android.frame_master.ui.bean.UserBean
import com.android.frame_master.util.PreDataStore
import com.frame.basic_library.base.basic.BasicActivity
import com.google.gson.Gson
import kotlinx.coroutines.*

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

        CoroutineScope(Dispatchers.Main).launch {
            //读取数据
            val s = PreDataStore.getData<String>("1") as String
            //
            val userBean = Gson().fromJson(s, UserBean::class.java)

            delay(1000)
            //登陆
            loginInit(userBean)
        }
    }

    private fun loginInit(userBean: UserBean) {
       // startActivity(Intent(this, ActivityFragment::class.java))
    }
}