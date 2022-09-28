package com.github.jhamin0511.mystudy.ui.paging.animal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.BaseListAdapter
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.databinding.ItemAnimalBinding

class AnimalAdapter : BaseListAdapter(DIFF_CALLBACK) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
            override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
                return oldItem.id() == newItem.id()
            }

            override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
                return if (oldItem is AnimalItem && newItem is AnimalItem) {
                    oldItem == newItem
                } else {
                    false
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAnimalBinding.inflate(inflater, parent, false)

        return AnimalHolder(binding)
    }
}
