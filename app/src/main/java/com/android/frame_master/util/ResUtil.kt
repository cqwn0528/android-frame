package com.android.frame_master.util

import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat

object ResUtil{
    /**
     * 获取 文字资源
     */
    fun getResString(strId: Int): String = CtxUtil.getAplContext().getString(strId)

    /**
     * 获取 Color资源
     */
    fun getResColor(colorId: Int): Int = ContextCompat.getColor(CtxUtil.getAplContext(), colorId)

    /**
     * 获取图片资源
     */
    fun getResDrawable(drawableId: Int): Drawable? =
        ContextCompat.getDrawable(CtxUtil.getAplContext(), drawableId)
}

