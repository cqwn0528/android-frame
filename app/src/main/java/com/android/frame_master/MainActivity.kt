package com.android.frame_master

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.android.frame_master.`fun`.TimerFun
import com.android.frame_master.base.BasicActivity
import com.android.frame_master.util.loadPic
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BasicActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        loadPic("https://pics6.baidu.com/feed/03087bf40ad162d9bb58337aabe817eb8b13cde5.png?token=802921089c14142f5e1f40864f25ac59&s=90B75D904A0372C0059F915D030090A2",img1)

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