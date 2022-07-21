package com.github.jhamin0511.mystudy.ui.selection

import com.github.jhamin0511.mystudy.databinding.ItemFoodBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item

class FoodHolder(
    private val binding: ItemFoodBinding
) : BaseHolder(binding.root) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as FoodItem
    }
}
