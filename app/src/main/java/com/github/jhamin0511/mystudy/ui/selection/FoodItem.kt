package com.github.jhamin0511.mystudy.ui.selection

import androidx.annotation.DrawableRes
import com.github.jhamin0511.mystudy.data.dto.food.FoodDto
import com.github.jhamin0511.mystudy.widget.recycler.Item

data class FoodItem(
    val id: Long,
    val title: String,
    val price: String,
    @DrawableRes
    val image: Int,
    val description: String,
    var favoriteCount: Int,
    var bookmarkCount: Int,
    var followCount: Int,
    var selected: Boolean
) : Item {
    companion object {
        fun create(value: FoodDto): FoodItem {
            return FoodItem(
                value.id,
                value.title,
                value.price,
                value.image,
                value.description,
                value.favoriteCount,
                value.bookmarkCount,
                value.followCount,
                false
            )
        }

        fun create(values: List<FoodDto>): List<FoodItem> {
            return values.map {
                create(it)
            }
        }
    }
}
