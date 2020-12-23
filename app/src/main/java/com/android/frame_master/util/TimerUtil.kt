package com.android.frame_master.util

import com.frame.basic_library.data.`fun`.TimerFun


object TimerUtil{
    /**
     * 计时器
     */
    fun timeMeter(timerInterface: TimerFun.TimerInterface, totalTime: Int = 60) {
        TimerFun.startTiming(timerInterface, totalTime)
    }
}


