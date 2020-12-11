package com.android.frame_master

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.android.frame_master.`fun`.TimerFun
import com.android.frame_master.util.immerseConfig
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    @RequiresApi(10000)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        immerseConfig(this)

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