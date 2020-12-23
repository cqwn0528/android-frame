package com.frame.basic_library.data.`fun`

import android.app.Activity
import java.util.*

/**
 * author cowards
 * created on 2018\10\17 0017
 */
object ActMgrFun {

    private var activityStack: Stack<Activity> = Stack()

    /**
     * 添加Activity到堆栈
     */
    fun addActivity(activity: Activity) = activityStack.add(activity)

    /**
     * 移除Activity从堆栈
     */
    fun removeActivity(activity: Activity) = activityStack.remove(activity)

    /**
     * 结束指定类名的Activity
     */
    fun finishActivity(cls: Class<*>) { for (activity in activityStack) {
            if (activity.javaClass == cls) { activityStack.remove(activity)
                activity.finish()
            }
        }
    }
}