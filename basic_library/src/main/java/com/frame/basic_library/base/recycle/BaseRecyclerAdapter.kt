package com.frame.basic_library.base.recycle

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<T>(//上下文环境
    private val context: Context, //数据集合
    private var dataList: MutableList<T> = mutableListOf()
) : RecyclerView.Adapter<BaseViewHolder>() {
    /**
     * 刷新数据
     *
     * @param dataList
     */
    fun refresh(dataList: MutableList<T>) {
        this.dataList = dataList
        notifyDataSetChanged()
    }

    /**
     * 添加数据
     *
     * @param dataList
     */
    fun append(dataList: MutableList<T>) {
        this.dataList.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(context).inflate(itemLayoutId, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val t = dataList[position]
        bindData(holder, t)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    /**
     * 将数据绑定到itemView视图上
     *
     * @param holder
     * @param t
     */
    abstract fun bindData(holder: BaseViewHolder?, t: T)

    /**
     * 子类通过重写此方法设置itemView项的布局视图
     *
     * @return
     */
    abstract val itemLayoutId: Int
}