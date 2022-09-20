package com.github.jhamin0511.mystudy.ui.paging.user

import com.github.jhamin0511.app.common.recycler.Item

data class DateItem(
    val date: String
) : Item {
    override fun id(): Long {
        return hashCode().toLong()
    }
}
