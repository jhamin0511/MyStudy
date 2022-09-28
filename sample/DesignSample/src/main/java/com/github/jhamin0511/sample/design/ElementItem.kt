package com.github.jhamin0511.sample.design

import com.github.jhamin0511.app.common.recycler.Item

data class ElementItem(
    val id: Long,
    val element: String,
    val navigation: Int
) : Item {
    override fun id() = id
}
