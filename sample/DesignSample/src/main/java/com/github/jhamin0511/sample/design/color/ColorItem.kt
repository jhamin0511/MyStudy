package com.github.jhamin0511.sample.design.color

import com.github.jhamin0511.app.common.recycler.Item

data class ColorItem(
    val id: Long,
    val colorName: String,
    val colorRes: Int,
    val colorHex: String,
) : Item {
    override fun id() = id
}
