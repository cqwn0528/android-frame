package com.frame.basic_library.base.basic

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.frame.basic_library.util.ActMgrUtil
import com.frame.basic_library.util.BarUtil

abstract class BasicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStateBar()
        setContentView(setLayoutId())
        initView()
        initData()
        initListener()
    }

    override fun onStart() {
        super.onStart()
        ActMgrUtil.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActMgrUtil.removeActivity(this)
    }


    abstract fun setLayoutId(): Int

    open fun initView() {}

    open fun initData() {}

    open fun initListener() {}

    private fun setStateBar() = BarUtil.stateBarConfig(this, Color.GREEN)

}