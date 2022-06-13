package com.github.jhamin0511.mystudy.widget.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseHolder<ITEM>(
    private val view: View
) : ViewHolder(view) {

    abstract fun bind(item: ITEM)

    fun setClickListener(
        item: ITEM,
        listener: AdapterClickListener<ITEM>
    ) {
        view.setOnClickListener {
            listener.onClickListener(adapterPosition, item)
        }
        view.setOnLongClickListener {
            listener.onLongClickListener(adapterPosition, item)
        }
    }
}
