package com.github.jhamin0511.app.common.recycler

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseListAdapter(
    diffCallback: DiffUtil.ItemCallback<Item>
) : ListAdapter<Item, BaseHolder>(diffCallback) {
    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
