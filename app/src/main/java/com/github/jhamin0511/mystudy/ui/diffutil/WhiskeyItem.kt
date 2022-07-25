package com.github.jhamin0511.mystudy.ui.diffutil

import androidx.annotation.DrawableRes
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.github.jhamin0511.mystudy.time.GlobalTime
import com.github.jhamin0511.mystudy.widget.recycler.Item

data class WhiskeyItem(
    val id: Long,
    val buyAt: String,
    @DrawableRes
    val image: Int,
    val name: String,
    val price: String,
    val description: String,
    var taste: WhiskeyTaste,
    var bookmark: Boolean,
    var favorite: Boolean,
    var follow: Boolean,
    var checked: Boolean = false,
) : Item {
    companion object {
        fun create(value: WhiskeyDto): WhiskeyItem {
            return WhiskeyItem(
                value.uuid,
                GlobalTime.convertDate(value.buyAt),
                value.image,
                value.name,
                value.price,
                value.description,
                value.taste,
                value.bookmark,
                value.favorite,
                value.follow
            )
        }

        fun create(values: List<WhiskeyDto>): List<WhiskeyItem> {
            return values.map {
                create(it)
            }
        }
    }
}
