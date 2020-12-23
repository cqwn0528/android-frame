package com.frame.basic_library.base.recycle

import android.util.SparseArray
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * 封装 ViewHolder
 */
class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    // item 中的控件缓存在这里
    private val views: SparseArray<View?> = SparseArray()

    fun getView(id: Int): View? {
        var view = views[id]
        if (view == null) {
            view = itemView.findViewById(id)
            views.put(id, view)
        }
        return view
    }
}