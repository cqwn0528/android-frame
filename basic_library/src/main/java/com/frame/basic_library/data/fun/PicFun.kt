package com.frame.basic_library.data.`fun`

import android.content.Context
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.core.content.ContextCompat

/**
 * 图片相关方法
 */
object PicFun {
    //对比图片是否相同
    fun comparedImg(ctx: Context, comparedImg: ImageView, beComparedImgId: Int): Boolean {
        //获取当前图片ConstantState类对象
        val dw1: Drawable.ConstantState? = comparedImg.drawable.current.constantState
        //找到需要比较的图片ConstantState类对象
        val dw2: Drawable.ConstantState? = ContextCompat.getDrawable(
            ctx, beComparedImgId
        )?.constantState
        return dw1 == dw2
    }
}