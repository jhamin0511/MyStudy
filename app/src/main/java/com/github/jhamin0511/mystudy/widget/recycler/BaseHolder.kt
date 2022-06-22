package com.github.jhamin0511.mystudy.widget.recycler

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder

open class BaseHolder(
    view: View
) : ViewHolder(view) {
    var item: BaseItem<*>? = null

    fun bind(item: BaseItem<*>, listener: ItemClickListener?) {
        this.item = item

        itemView.setOnClickListener {
            listener?.onClickListener(adapterPosition, item)
        }
        itemView.setOnLongClickListener {
            listener?.onLongClickListener(adapterPosition, item) ?: false
        }
    }
}
