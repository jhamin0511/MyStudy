package com.github.jhamin0511.mystudy.ui.paging

import android.view.ViewGroup
import com.github.jhamin0511.mystudy.widget.recycler.BaseAdapter
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick

class PagingAdapter(
    private val userClickListener: ItemClick
) : BaseAdapter() {

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DateItem -> PagingHolder.DATE
            is UserItem -> PagingHolder.USER
            else -> throw IllegalArgumentException("not support type.")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val view = onCreateView(parent, viewType)

        return when (viewType) {
            PagingHolder.DATE -> {
                DateHolder(view)
            }
            PagingHolder.USER -> {
                UserHolder(view, userClickListener)
            }
            else -> {
                throw IllegalArgumentException("not support type.")
            }
        }
    }
}
