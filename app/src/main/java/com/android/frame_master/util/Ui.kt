package com.android.frame_master.util

import android.app.Activity
import android.os.Build
import android.view.*
import androidx.annotation.RequiresApi


@RequiresApi(Build.VERSION_CODES.R)
fun immerseConfig(activity: Activity) {
    activity.window.setDecorFitsSystemWindows(false)
    val controller = activity.window.insetsController
    if (controller != null) {
        controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        controller.systemBarsBehavior =
            WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
    }
}