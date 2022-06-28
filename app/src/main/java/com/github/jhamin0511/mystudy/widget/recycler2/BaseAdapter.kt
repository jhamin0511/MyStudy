package com.github.jhamin0511.mystudy.widget.recycler2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter : RecyclerView.Adapter<BaseHolder<*>>() {
    private val items = mutableListOf<Item>()

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: BaseHolder<*>, position: Int) {
        holder.bind(items[position])
    }

    protected fun onCreateView(parent: ViewGroup, @LayoutRes layout: Int): View {
        val inflater = LayoutInflater.from(parent.context)

        return inflater.inflate(layout, parent, false)
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    fun addItem(e: Item) {
        items.add(e)
        notifyItemChanged(items.size)
    }

    fun addItems(e: List<Item>) {
        val preSize = items.size
        items.addAll(e)
        notifyItemChanged(preSize, items.size)
    }

    fun getItem(position: Int): Item {
        return items[position]
    }

    fun removeItem(e: Item) {
        val position = items.indexOf(e)
        items.removeAt(position)
        notifyItemRemoved(position)
    }
}
