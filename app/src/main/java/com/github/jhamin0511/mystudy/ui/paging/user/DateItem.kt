package com.github.jhamin0511.mystudy.ui.paging.user

import com.github.jhamin0511.mystudy.widget.recycler.Item

data class DateItem(
    val date: String
) : Item {
    override fun id(): Long {
        return hashCode().toLong()
    }
}
