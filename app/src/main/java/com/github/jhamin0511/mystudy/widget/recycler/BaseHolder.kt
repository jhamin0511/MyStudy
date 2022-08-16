package com.github.jhamin0511.mystudy.widget.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder(
    view: View,
    holderClick: HolderClickListener? = null,
    holderLongClick: HolderLongClickListener? = null,
    itemClick: HolderItemClickListener? = null,
    itemLongClick: HolderItemLongClickListener? = null
) : RecyclerView.ViewHolder(view) {
    lateinit var item: Item

    init {
        if (holderClick != null) {
            view.setOnClickListener {
                holderClick.onClick(item.id(), absoluteAdapterPosition)
            }
        }
        if (holderLongClick != null) {
            view.setOnLongClickListener {
                holderLongClick.onLongClick(item.id(), absoluteAdapterPosition)
                true
            }
        }
        if (itemClick != null) {
            view.setOnClickListener {
                itemClick.onClick(item, absoluteAdapterPosition)
            }
        }
        if (itemLongClick != null) {
            view.setOnLongClickListener {
                itemLongClick.onLongClick(item, absoluteAdapterPosition)
                true
            }
        }
    }

    open fun bind(item: Item) {
        this.item = item
    }
}
