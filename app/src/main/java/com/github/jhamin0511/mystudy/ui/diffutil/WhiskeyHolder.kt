package com.github.jhamin0511.mystudy.ui.diffutil

import com.github.jhamin0511.mystudy.BR
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.github.jhamin0511.mystudy.databinding.ItemWhiskeyBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.HolderClickListener
import com.github.jhamin0511.mystudy.widget.recycler.HolderLongClickListener
import com.github.jhamin0511.mystudy.widget.recycler.Item

class WhiskeyHolder(
    private val binding: ItemWhiskeyBinding,
    private val holderClick: HolderClickListener,
    private val holderLongClick: HolderLongClickListener,
    private val itemClick: WhiskeyItemClickListener
) : BaseHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            val whiskey = item as WhiskeyItem
            holderClick.onClick(whiskey.id, absoluteAdapterPosition)
        }
        binding.root.setOnLongClickListener {
            val whiskey = item as WhiskeyItem
            holderLongClick.onLongClick(whiskey.id, absoluteAdapterPosition)
            true
        }
        binding.ivImage.setOnClickListener {
            val whiskey = item as WhiskeyItem
            itemClick.onClickImage(whiskey.image)
        }
        binding.ivTaste.setOnClickListener {
            val whiskey = item as WhiskeyItem
            whiskey.taste = WhiskeyTaste.rotate(whiskey.taste)
            binding.setVariable(BR.item, item)
        }
        binding.ivBookmark.setOnClickListener {
            val whiskey = item as WhiskeyItem
            whiskey.bookmark = !whiskey.bookmark
            binding.setVariable(BR.item, item)
        }
        binding.ivFavorite.setOnClickListener {
            val whiskey = item as WhiskeyItem
            whiskey.favorite = !whiskey.favorite
            binding.setVariable(BR.item, item)
        }
        binding.ivFollow.setOnClickListener {
            val whiskey = item as WhiskeyItem
            whiskey.follow = !whiskey.follow
            binding.setVariable(BR.item, item)
        }
    }

    override fun bind(item: Item) {
        super.bind(item)

        binding.setVariable(BR.item, item)
    }
}
