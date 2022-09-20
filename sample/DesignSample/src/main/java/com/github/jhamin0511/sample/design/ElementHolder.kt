package com.github.jhamin0511.sample.design

import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.HolderItemClickListener
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.sample.design.databinding.ItemElementBinding

class ElementHolder(
    private val binding: ItemElementBinding,
    itemClick: HolderItemClickListener
) : BaseHolder(
    binding.root,
    itemClick = itemClick
) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as ElementItem
    }
}
