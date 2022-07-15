package com.github.jhamin0511.mystudy.ui.paging.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.github.jhamin0511.mystudy.databinding.ItemDateBinding
import com.github.jhamin0511.mystudy.databinding.ItemUserBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick
import com.github.jhamin0511.mystudy.widget.recycler.ItemLongClick

class UserAdapter(
    private val userClick: ItemClick,
    private val userLongClick: ItemLongClick
) : PagingDataAdapter<Item, BaseHolder>(DIFF_CALLBACK) {
    companion object {
        @VisibleForTesting
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return if (oldItem is DateItem && newItem is DateItem) {
                    oldItem.date == newItem.date
                } else if (oldItem is UserItem && newItem is UserItem) {
                    oldItem.id == newItem.id
                } else {
                    false
                }
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return if (oldItem is DateItem && newItem is DateItem) {
                    oldItem == newItem
                } else if (oldItem is UserItem && newItem is UserItem) {
                    oldItem == newItem
                } else {
                    false
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DateItem -> PagingHolder.DATE
            is UserItem -> PagingHolder.USER
            else -> throw IllegalArgumentException("not support type.")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            PagingHolder.DATE -> {
                val binding = ItemDateBinding.inflate(inflater, parent, false)
                DateHolder(binding)
            }
            PagingHolder.USER -> {
                val binding = ItemUserBinding.inflate(inflater, parent, false)
                UserHolder(binding, userClick, userLongClick)
            }
            else -> {
                throw IllegalArgumentException("not support type.")
            }
        }
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }
}
