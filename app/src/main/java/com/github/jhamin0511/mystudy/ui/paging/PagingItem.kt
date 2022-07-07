package com.github.jhamin0511.mystudy.ui.paging

import androidx.annotation.DrawableRes
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.time.GlobalTime
import com.github.jhamin0511.mystudy.widget.recycler.Item

object PagingItem {
    fun createUser(value: UserDto): UserItem {
        return UserItem(
            value.id,
            value.type.icon,
            GlobalTime.convertDate(value.createAt),
            value.name,
            value.age,
            value.introduce
        )
    }
}

data class UserItem(
    val id: Long,
    @DrawableRes
    val icon: Int,
    val createdAt: String,
    val name: String,
    val age: Int,
    val introduce: String
) : Item

data class DateItem(
    val date: String
) : Item
