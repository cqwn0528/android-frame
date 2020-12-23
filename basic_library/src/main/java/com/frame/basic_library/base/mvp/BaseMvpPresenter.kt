package com.frame.basic_library.base.mvp

open class BaseMvpPresenter<V : BaseMvpView?> {
    protected var mView: V? = null

    /**
     * 绑定view，一般在初始化中调用该方法
     *
     * @param view view
     */
    fun attachView(view: V) {
        mView = view
    }

    /**
     * 解除绑定view，一般在onDestroy中调用
     */
    fun detachView() {
        mView = null
    }

    /**
     * View是否绑定
     *
     * @return
     */
    val isViewAttached: Boolean
        get() = mView != null
}