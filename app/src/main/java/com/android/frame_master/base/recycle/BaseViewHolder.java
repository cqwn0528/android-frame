package com.android.frame_master.base.recycle;

import android.util.SparseArray;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

/**
 * 封装 ViewHolder
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    // item 中的控件缓存在这里
    private SparseArray<View> views;

    public BaseViewHolder(View itemView) {
        super(itemView);
        views = new SparseArray<>();
    }

    /**
     * 获取 itemView 中的控件
     *
     * @param id
     * @return
     */
    public View getView(int id) {
        View view = views.get(id);
        if (view == null) {
            view = itemView.findViewById(id);
            views.put(id, view);
        }
        return view;
    }
}