package com.android.frame_master.util

import android.app.Activity
import com.android.frame_master.data.`fun`.ActMgrFun

/**
 * 添加Activity
 */
fun addActivity(activity: Activity) = ActMgrFun.addActivity(activity)

/**
 * 移除Activity
 */
fun removeActivity(activity: Activity) = ActMgrFun.removeActivity(activity)

/**
 * 结束指定Activity
 */
fun finishAssignActivity(cls: Class<*>) = ActMgrFun.finishActivity(cls)