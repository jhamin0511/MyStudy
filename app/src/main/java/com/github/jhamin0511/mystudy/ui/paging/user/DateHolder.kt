package com.github.jhamin0511.mystudy.ui.paging.user

import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.databinding.ItemDateBinding

class DateHolder(
    private val binding: ItemDateBinding
) : BaseHolder(binding.root) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as DateItem
    }
}
