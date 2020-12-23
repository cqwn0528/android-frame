package com.frame.basic_library.base.mvp

interface BaseMvpView {
    /**
     * 显示加载中
     */
    fun showLoading()

    /**
     * 隐藏加载
     */
    fun hideLoading()
    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
    </T> */
    /* <T> AutoDisposeConverter<T> bindAutoDispose();*/
}