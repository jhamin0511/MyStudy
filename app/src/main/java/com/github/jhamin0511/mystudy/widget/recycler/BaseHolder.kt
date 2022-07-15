package com.github.jhamin0511.mystudy.widget.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseHolder(
    view: View,
    click: ItemClick? = null,
    longClick: ItemLongClick? = null
) : RecyclerView.ViewHolder(view) {
    lateinit var item: Item

    init {
        if (click != null) {
            view.setOnClickListener {
                click.onClick(item, absoluteAdapterPosition)
            }
        }
        if (longClick != null) {
            view.setOnLongClickListener {
                longClick.onLongClick(item, absoluteAdapterPosition)
                true
            }
        }
    }

    open fun bind(item: Item) {
        this.item = item
    }
}
