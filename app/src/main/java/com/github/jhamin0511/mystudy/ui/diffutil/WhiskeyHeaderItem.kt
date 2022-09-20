package com.github.jhamin0511.mystudy.ui.diffutil

import com.github.jhamin0511.app.common.recycler.Item

data class WhiskeyHeaderItem(
    val date: String
) : Item {
    override fun id(): Long {
        return hashCode().toLong()
    }
}
