package com.android.frame_master.base

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.frame_master.util.addActivity
import com.android.frame_master.util.removeActivity
import com.android.frame_master.util.stateBarConfig

abstract class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStateBar()
        setContentView(setLayoutId())
        initView()
        initData()
        initListener()
    }

    private fun setStateBar() = stateBarConfig(this, Color.GREEN)

    abstract fun setLayoutId(): Int

    abstract fun initView()

    open  fun initData() {}

    open fun initListener() {}

    override fun onStart() {
        super.onStart()
        addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        removeActivity(this)
    }
}