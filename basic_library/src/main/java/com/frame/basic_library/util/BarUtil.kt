package com.frame.basic_library.util

import android.app.Activity
import android.view.*
import androidx.core.view.ViewCompat

/**
 * 配置状态栏
 */

object BarUtil {
    fun stateBarConfig(activity: Activity, bgColor: Int) {
        val window: Window = activity.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = bgColor
    }

    fun setBarLight(view: View, isLight: Boolean) {
        val controller = ViewCompat.getWindowInsetsController(view)
        controller?.isAppearanceLightStatusBars = isLight
    }

}




