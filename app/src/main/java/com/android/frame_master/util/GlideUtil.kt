package com.android.frame_master.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

/**
 * 加载图片
 */
fun loadPic(
    url: Any,
    view: ImageView,
    error: Int = 0,
    placeholder: Int = 0
) {
    Glide
        .with(getAplContext())
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transition(DrawableTransitionOptions().crossFade())
        .into(view)
}

/**
 * 加载圆形图片
 */
fun loadCirclePic(
    url: Any,
    view: ImageView,
    error: Int = 0,
    placeholder: Int = 0
) {
    Glide
        .with(getAplContext())
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .circleCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transition(DrawableTransitionOptions().crossFade())
        .into(view)
}

/**
 * 加载圆角图片
 */
fun loadCircularPic(
    url: Any,
    view: ImageView,
    circular: Int,
    error: Int = 0,
    placeholder: Int = 0
) {
    Glide
        .with(getAplContext())
        .load(url)
        .placeholder(placeholder)
        .error(error)
        .transform(RoundedCorners(circular))
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .transition(DrawableTransitionOptions().crossFade())
        .into(view)
}