package com.android.frame_master

import com.android.frame_master.ui.activity.HomeFmActivity
import com.android.frame_master.ui.activity.LoginActivity
import com.android.frame_master.ui.activity.NavigationActivity
import com.android.frame_master.ui.bean.AppInfoBean
import com.android.frame_master.util.Constant
import com.android.frame_master.util.PreDataStore
import com.android.frame_master.util.SystemUtil
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

    override fun initData() {
        CoroutineScope(Dispatchers.Main).launch {
            //读取数据
            val appInfoStr = PreDataStore.getData<String>(Constant.APP_INFO) as String

            delay(1200)

            if (appInfoStr.isEmpty()) {
                SystemUtil.startActivity(this@MainActivity, NavigationActivity::class.java)
            } else {
                //登陆
                val appInfoBean = Gson().fromJson(appInfoStr, AppInfoBean::class.java)

                if (appInfoBean.isLogin) {
                    SystemUtil.startActivity(this@MainActivity, LoginActivity::class.java)
                } else {
                    SystemUtil.startActivity(this@MainActivity, HomeFmActivity::class.java)
                }
            }
        }
    }
}