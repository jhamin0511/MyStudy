package com.github.jhamin0511.mystudy.ui.common.recycler

import com.github.jhamin0511.mystudy.databinding.ItemDateBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item

class DateHolder(
    private val binding: ItemDateBinding
) : BaseHolder(binding.root) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as DateItem
    }
}
