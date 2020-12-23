package com.frame.basic_library.util

import android.app.Activity
import com.frame.basic_library.data.`fun`.ActMgrFun

object ActMgrUtil {

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
}
