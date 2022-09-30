package com.github.jhamin0511.mystudy.ui.diffutil

import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.HolderClickListener
import com.github.jhamin0511.app.common.recycler.HolderLongClickListener
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.BR
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.github.jhamin0511.mystudy.databinding.ItemWhiskeyBinding

class WhiskeyHolder(
    private val binding: ItemWhiskeyBinding,
    holderClick: HolderClickListener,
    holderLongClick: HolderLongClickListener,
    private val itemClick: WhiskeyItemClickListener
) : BaseHolder(
    binding.root,
    holderClick = holderClick,
    holderLongClick = holderLongClick
) {

    init {
        binding.ivSelect.setOnClickListener {
            val whiskey = item as WhiskeyItem
            val selected = itemClick.onClickSelect(whiskey.id)
            whiskey.select = selected
            binding.setVariable(BR.item, item)
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
