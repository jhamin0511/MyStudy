package com.github.jhamin0511.mystudy.widget.recycler

import androidx.recyclerview.widget.RecyclerView

class AdapterQueryImpl(
    private val adapter: RecyclerView.Adapter<*>
) : AdapterQuery {
    private val items = mutableListOf<AdapterItem>()

    override fun size(): Int {
        return items.size
    }

    override fun isEmptyItem(): Boolean {
        return items.isEmpty()
    }

    override fun getItem(position: Int): AdapterItem {
        return items[position]
    }

    override fun getItems(): List<AdapterItem> {
        return items
    }

    override fun addItem(e: AdapterItem) {
        items.add(e)
        adapter.notifyItemChanged(items.size)
    }

    override fun addItems(e: List<AdapterItem>) {
        val start = items.size
        items.addAll(e)
        adapter.notifyItemRangeChanged(start, items.size)
    }

    override fun clearItem() {
        val preSize = items.size
        items.clear()
        adapter.notifyItemRangeRemoved(0, preSize)
    }

    override fun removeItem(e: AdapterItem) {
        val position = items.indexOf(e)
        adapter.notifyItemRemoved(position)
    }

    override fun removeItem(position: Int) {
        items.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}
