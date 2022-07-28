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
    var select: Boolean = false
) : Item {
    override fun id(): Long {
        return id
    }

    companion object {
        fun create(value: WhiskeyDto, isSelect: Boolean): WhiskeyItem {
            return WhiskeyItem(
                value.id,
                GlobalTime.convertDate(value.buyAt),
                value.image,
                value.name,
                value.price,
                value.description,
                value.taste,
                value.bookmark,
                value.favorite,
                value.follow,
                isSelect
            )
        }

        fun create(values: List<WhiskeyDto>, selection: List<Long>): List<WhiskeyItem> {
            return values.map {
                val select = selection.contains(it.id)
                create(it, select)
            }
        }
    }
}
