package com.github.jhamin0511.mystudy.ui.selection

import com.github.jhamin0511.mystudy.BR
import com.github.jhamin0511.mystudy.databinding.ItemFoodBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item

class FoodHolder(
    private val binding: ItemFoodBinding,
    private val clickListener: FoodItemClickListener
) : BaseHolder(binding.root) {
    init {
        binding.ivImage.setOnClickListener {
            val foodItem = item as FoodItem
            clickListener.onClickImage(foodItem.image)
        }
        binding.ivFavorite.setOnClickListener {
            val foodItem = item as FoodItem
            foodItem.favoriteCount++
            binding.setVariable(BR.item, item)
        }
        binding.ivBookmark.setOnClickListener {
            val foodItem = item as FoodItem
            foodItem.bookmarkCount++
            binding.setVariable(BR.item, item)
        }
        binding.ivFollow.setOnClickListener {
            val foodItem = item as FoodItem
            foodItem.followCount++
            binding.setVariable(BR.item, item)
        }
        binding.ivSelect.setOnClickListener {
            val foodItem = item as FoodItem
            foodItem.selected = !foodItem.selected
            binding.setVariable(BR.item, item)
        }
    }

    override fun bind(item: Item) {
        super.bind(item)

        binding.setVariable(BR.item, item)
        binding.executePendingBindings()
    }
}
