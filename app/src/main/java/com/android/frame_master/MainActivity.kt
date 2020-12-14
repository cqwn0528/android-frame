package com.android.frame_master

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.android.frame_master.`fun`.TimerFun
import com.android.frame_master.base.BasicActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasicActivity() {

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
}