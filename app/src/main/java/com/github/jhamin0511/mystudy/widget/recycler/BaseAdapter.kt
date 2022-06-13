package com.github.jhamin0511.mystudy.widget.recycler

import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder

abstract class BaseAdapter<ITEM> : Adapter<ViewHolder>(), AdapterItem<ITEM> {
    private val items = mutableListOf<ITEM>()

    override fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    override fun add(e: ITEM) {
        items.add(e)
        notifyItemChanged(items.size)
    }

    override fun addAll(e: List<ITEM>) {
        val start = items.size

        items.addAll(e)
        notifyItemRangeChanged(start, items.size)
    }

    override fun clear() {
        val preSize = items.size

        items.clear()
        notifyItemRangeRemoved(0, preSize)
    }

    override fun remove(e: ITEM) {
        val position = items.indexOf(e)

        notifyItemRemoved(position)
    }

    override fun remove(position: Int) {
        items.removeAt(position)

        notifyItemRemoved(position)
    }

    override fun get(position: Int): ITEM {
        return items[position]
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
