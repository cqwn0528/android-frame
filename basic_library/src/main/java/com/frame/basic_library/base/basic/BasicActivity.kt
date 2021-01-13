package com.frame.basic_library.base.basic

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.frame.basic_library.util.BarUtil
import java.lang.reflect.ParameterizedType

open class BasicActivity<VB : ViewBinding> : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStateBar()
        setContentView(binding.root)
        initView()
        initData()
        initListener()
    }

    open fun initView() {}

    open fun initData() {}

    open fun initListener() {}

    private fun setStateBar() = BarUtil.stateBarConfig(this, Color.WHITE)


    protected val binding: VB by lazy {
        //使用反射得到viewBinding的class
        val type = javaClass.genericSuperclass as ParameterizedType
        val aClass = type.actualTypeArguments[0] as Class<*>
        val method = aClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        method.invoke(null, layoutInflater) as VB
    }
}
