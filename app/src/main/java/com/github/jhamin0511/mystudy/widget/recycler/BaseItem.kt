package com.github.jhamin0511.mystudy.widget.recycler

import android.view.View
import androidx.annotation.LayoutRes

abstract class BaseItem<VH : BaseHolder> : AdapterItem {

    @LayoutRes
    abstract fun getItemLayout(): Int

    override fun get(): BaseItem<*> {
        return this
    }

    open fun createViewHolder(view: View): VH {
        @Suppress("UNCHECKED_CAST")
        return BaseHolder(view) as VH
    }

    open fun bind(
        holder: VH,
        position: Int,
        payloads: List<Any>?,
        listener: ItemClickListener?
    ) {
        holder.bind(this, listener)
        bind(holder, position, payloads)
    }

    abstract fun bind(holder: VH, position: Int)

    open fun bind(
        holder: VH,
        position: Int,
        payloads: List<Any>?,
    ) {
        bind(holder, position)
    }

    fun getViewType(): Int {
        return getItemLayout()
    }
}
