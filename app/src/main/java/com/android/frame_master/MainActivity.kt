package com.android.frame_master

import android.app.Activity
import android.os.Bundle
import androidx.lifecycle.LifecycleCoroutineScope
import com.android.frame_master.ui.bean.TextBean
import com.android.frame_master.util.DataStoreUtil
import com.android.frame_master.util.GlideUtil
import com.android.frame_master.util.HttpUtil
import com.frame.basic_library.data.net.HttpCallback
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        GlideUtil.loadPic(
            "https://pics6.baidu.com/feed/03087bf40ad162d9bb58337aabe817eb8b13cde5.png?token=802921089c14142f5e1f40864f25ac59&s=90B75D904A0372C0059F915D030090A2",
            img1
        )

        btn1.setOnClickListener {
            GlobalScope.launch {
                DataStoreUtil.saveData("", "")
            }
        }

        btn2.setOnClickListener {
            HttpUtil.getRequest("https://www.baidu.com", object : HttpCallback<TextBean>() {
                override fun onSuccess(response: TextBean) {
                }

                override fun onError(msg: String) {
                }

                override fun onFail() {

                }
            }, TextBean::class.java)
        }
    }
}