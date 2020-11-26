package com.android.frame_master

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btn1.setOnClickListener {
            TimerUtil1.startTiming(object : TimerUtil1.TimerInterface1 {
                override fun timing(time: Int) {
                    Log.e("几十种", "" + time)
                }

                override fun timeEnds() {
                    Log.e("几十结束", "哈哈")
                }
            })
        }
    }
}