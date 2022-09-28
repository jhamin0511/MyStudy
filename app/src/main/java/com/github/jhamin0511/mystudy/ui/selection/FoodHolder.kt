package com.github.jhamin0511.mystudy.ui.selection

import androidx.recyclerview.selection.ItemDetailsLookup
import com.github.jhamin0511.app.common.recycler.BaseHolder
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.BR
import com.github.jhamin0511.mystudy.databinding.ItemFoodBinding

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
    }

    override fun bind(item: Item) {
        super.bind(item)

        binding.setVariable(BR.item, item)
    }

    fun getItemDetails(): ItemDetailsLookup.ItemDetails<Long> {
        return object : ItemDetailsLookup.ItemDetails<Long>() {
            override fun getPosition(): Int {
                return absoluteAdapterPosition
            }

            override fun getSelectionKey(): Long? {
                return (item as FoodItem).id
            }
        }
    }

    fun select(selected: Boolean) {
        binding.ivSelect.isSelected = selected
    }
}
