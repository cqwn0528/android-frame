package com.android.frame_master.base;

/**
 * @author azheng
 * @date 2018/4/24.
 * GitHub：https://github.com/RookieExaminer
 * Email：wei.azheng@foxmail.com
 * Description：
 */
public class BaseMvpView {

    /**
     * 显示加载中
     */
    public void showLoading() {
    }

    /**
     * 隐藏加载
     */
    public void hideLoading() {
    }



    /**
     * 绑定Android生命周期 防止RxJava内存泄漏
     *
     * @param <T>
     * @return
     */
    /* <T> AutoDisposeConverter<T> bindAutoDispose();*/

}
