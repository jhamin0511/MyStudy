package com.github.jhamin0511.mystudy.ui.paging

import androidx.annotation.DrawableRes
import com.github.jhamin0511.mystudy.widget.recycler2.Item

data class UserItem(
    val id: Long,
    @DrawableRes
    val icon: Int,
    val createdAt: String,
    val name: String,
    val age: Int,
    val introduce: String
) : Item
