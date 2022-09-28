package com.github.jhamin0511.sample.design.color

import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.sample.design.databinding.ItemColorBinding

class ColorHolder(
    private val binding: ItemColorBinding
) : BaseHolder(binding.root) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as ColorItem
    }
}
