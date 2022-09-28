package com.github.jhamin0511.mystudy.ui.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.BaseListAdapter
import com.github.jhamin0511.app.common.recycler.HolderClickListener
import com.github.jhamin0511.app.common.recycler.HolderLongClickListener
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ItemWhiskeyBinding
import com.github.jhamin0511.mystudy.databinding.ItemWhiskeyHeaderBinding
import com.github.jhamin0511.mystudy.ui.diffutil.HolderType.HEADER
import com.github.jhamin0511.mystudy.ui.diffutil.HolderType.WHISKEY

object HolderType {
    const val HEADER = R.layout.item_whiskey_header
    const val WHISKEY = R.layout.item_whiskey
}

class WhiskeyAdapter(
    private val holderClick: HolderClickListener,
    private val holderLongClick: HolderLongClickListener,
    private val itemClick: WhiskeyItemClickListener
) : BaseListAdapter(DIFF_CALLBACK) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return if (oldItem is WhiskeyItem && newItem is WhiskeyItem) {
                    oldItem.id == newItem.id
                } else if (oldItem is WhiskeyHeaderItem && newItem is WhiskeyHeaderItem) {
                    oldItem.date == newItem.date
                } else {
                    false
                }
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return if (oldItem is WhiskeyItem && newItem is WhiskeyItem) {
                    oldItem == newItem
                } else if (oldItem is WhiskeyHeaderItem && newItem is WhiskeyHeaderItem) {
                    oldItem.date == newItem.date
                } else {
                    false
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)

        return if (item is WhiskeyHeaderItem) {
            HEADER
        } else {
            WHISKEY
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            HEADER -> {
                val binding = ItemWhiskeyHeaderBinding.inflate(inflater, parent, false)
                WhiskeyHeaderHolder(binding)
            }
            WHISKEY -> {
                val binding = ItemWhiskeyBinding.inflate(inflater, parent, false)
                WhiskeyHolder(binding, holderClick, holderLongClick, itemClick)
            }
            else -> throw IllegalArgumentException("not create ViewHolder.")
        }
    }
}
