package com.android.frame_master.util

import android.app.Activity
import android.content.Intent
import android.os.Bundle

object JumpUtil {

    /**
     * 跳转
     */
    fun jumpTo(activity: Activity, cls: Class<*>?, params: MutableMap<String, *>? = null) {
        val intent = Intent(activity, cls)
        if (params != null) {
            activity.startActivity(handleParams(params, intent))
        } else {
            activity.startActivity(intent)
        }
    }

    /**
     * 带返回结果的跳转
     */
    fun jumpToForResult(
        activity: Activity,
        cls: Class<*>?,
        requestCode: Int,
        params: MutableMap<String, *>? = null
    ) {
        val intent = Intent(activity, cls)
        if (params != null) {
            activity.startActivityForResult(handleParams(params, intent), requestCode)
        } else {
            activity.startActivityForResult(intent, requestCode)
        }
    }

    /**
     * 处理传递的参数
     */
    private fun handleParams(params: MutableMap<String, *>, intent: Intent): Intent {
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
                else -> {
                    throw RuntimeException("unknown type")
                }
            }
        }
        intent.putExtras(bundle)
        return intent
    }
}