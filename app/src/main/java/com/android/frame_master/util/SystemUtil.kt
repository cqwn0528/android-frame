package com.android.frame_master.util

import android.app.Activity
import android.content.Intent
import android.os.Bundle

object SystemUtil {

    /**
     * 开启activity
     */
    fun startActivity(activity: Activity, clazz: Class<*>, params: Map<String, *>? = null) {
        val intent = Intent(activity, clazz::class.java)
        if (params != null) {
            val bundle = Bundle()
            params.forEach {
                when (it.value) {
                    String::class -> {
                        bundle.putString(it.key, it.value as String)
                    }
                    Int::class -> {
                        bundle.putInt(it.key, it.value as Int)
                    }
                    Boolean::class -> {
                        bundle.putBoolean(it.key, it.value as Boolean)
                    }
                    Float::class -> {
                        bundle.putFloat(it.key, it.value as Float)
                    }
                    Double::class -> {
                        bundle.putDouble(it.key, it.value as Double)
                    }
                    Long::class -> {
                        bundle.putLong(it.key, it.value as Long)
                    }
                }
            }
            intent.putExtra(Constant.BUNDLE_PARAMS, bundle)
        }
        activity.startActivity(intent)
    }

    /**
     * 获取activity传递的参数
     */
    fun getParams(activity: Activity): Bundle? {
        return activity.intent.getBundleExtra(Constant.BUNDLE_PARAMS)
    }
}