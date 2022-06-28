package com.github.jhamin0511.mystudy.widget.recycler2

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class BaseHolder<BINDING : ViewBinding>(
    view: View,
) : RecyclerView.ViewHolder(view) {
    val binding: BINDING = DataBindingUtil.bind(view)!!

    abstract fun bind(item: Item)
}
