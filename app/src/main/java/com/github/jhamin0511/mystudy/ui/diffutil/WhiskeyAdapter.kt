package com.github.jhamin0511.mystudy.ui.diffutil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.github.jhamin0511.mystudy.databinding.ItemWhiskeyBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.BaseListAdapter
import com.github.jhamin0511.mystudy.widget.recycler.Item

class WhiskeyAdapter : BaseListAdapter(DIFF_CALLBACK) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return if (oldItem is WhiskeyItem && newItem is WhiskeyItem) {
                    oldItem.id == newItem.id
                } else {
                    false
                }
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return if (oldItem is WhiskeyItem && newItem is WhiskeyItem) {
                    oldItem == newItem
                } else {
                    false
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemWhiskeyBinding.inflate(inflater, parent, false)

        return WhiskeyViewHolder(binding)
    }
}
