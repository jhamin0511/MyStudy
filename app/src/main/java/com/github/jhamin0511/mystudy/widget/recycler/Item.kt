package com.github.jhamin0511.mystudy.widget.recycler

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class Item<B : ViewDataBinding> : BaseItem<Holder<B>>() {

    abstract fun bind(binding: B, position: Int)

    override fun createViewHolder(view: View): Holder<B> {
        val binding: B = DataBindingUtil.bind(view)!!

        return Holder(binding)
    }

    override fun bind(
        holder: Holder<B>,
        position: Int,
        payloads: List<Any>?,
        listener: ItemClickListener?
    ) {
        super.bind(holder, position, payloads, listener)
        holder.binding.executePendingBindings()
    }

    override fun bind(holder: Holder<B>, position: Int) {
        throw IllegalAccessError("Doesn't get called")
    }

    override fun bind(holder: Holder<B>, position: Int, payloads: List<Any>?) {
        bind(holder.binding, position)
    }
}
