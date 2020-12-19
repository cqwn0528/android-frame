package com.android.frame_master.data.`fun`

import kotlinx.coroutines.*

/**
 * 计时器功能
 */
object TimerFun {
    private var uiScope = CoroutineScope(Dispatchers.Main)
    //开始计时
    fun startTiming(timerInterface: TimerInterface, totalTime: Int = 60) {
        var timer = totalTime
        uiScope.cancel()
        uiScope = CoroutineScope(Dispatchers.Main)
        uiScope.launch {
            while (timer >= 1) {
                delay(1_000)
                timer--
                timerInterface.timing(timer)
            }
            timerInterface.timeEnds()
        }
    }

    //计时回调
    interface TimerInterface {
        fun timing(time: Int)
        fun timeEnds()
    }
}