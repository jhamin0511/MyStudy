package com.github.jhamin0511.mystudy.ui.paging.user

import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.HolderItemClickListener
import com.github.jhamin0511.app.common.recycler.HolderItemLongClickListener
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.databinding.ItemUserBinding

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
