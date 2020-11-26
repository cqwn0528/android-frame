package com.android.frame_master

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.frame_master.`fun`.RegularFun
import com.android.frame_master.retrofit.HttpUtil
import com.android.frame_master.`fun`.TimerFun
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener {
            TimerFun.startTiming(object : TimerFun.TimerInterface {
                override fun timing(time: Int) {
                    Log.e("几十种", "" + time)
                }

                override fun timeEnds() {
                    Log.e("几十结束", "哈哈")
                }
            })
        }
        btn2.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }

    private fun initList() {
        GlobalScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.Default) {
                HttpUtil.get().getApiService().getUserInfo()
            }
        }
    }
}