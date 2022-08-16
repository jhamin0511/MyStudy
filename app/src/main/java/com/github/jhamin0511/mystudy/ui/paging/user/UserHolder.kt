package com.github.jhamin0511.mystudy.ui.paging.user

import com.github.jhamin0511.mystudy.databinding.ItemUserBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.HolderItemClickListener
import com.github.jhamin0511.mystudy.widget.recycler.HolderItemLongClickListener
import com.github.jhamin0511.mystudy.widget.recycler.Item


class UserHolder(
    private val binding: ItemUserBinding,
    itemClick: HolderItemClickListener,
    itemLongClick: HolderItemLongClickListener
) : BaseHolder(
    binding.root,
    itemClick = itemClick,
    itemLongClick = itemLongClick
) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as UserItem
    }
}
