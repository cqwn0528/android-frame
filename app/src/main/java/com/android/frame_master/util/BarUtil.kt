package com.android.frame_master.util

import android.app.Activity
import android.view.*

/**
 * 配置状态栏
 */
fun stateBarConfig(activity: Activity, bgColor: Int) {
    val window: Window = activity.window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor = bgColor
}


