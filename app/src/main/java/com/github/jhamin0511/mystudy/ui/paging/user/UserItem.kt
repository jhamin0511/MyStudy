package com.github.jhamin0511.mystudy.ui.paging.user

import androidx.annotation.DrawableRes
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.time.GlobalTime
import com.github.jhamin0511.mystudy.widget.recycler.Item

data class UserItem(
    val id: Long,
    @DrawableRes
    val picture: Int,
    var date: String,
    var name: String,
    val age: Int,
    val introduce: String
) : Item {
    companion object {
        fun create(value: UserDto): UserItem {
            return UserItem(
                value.id,
                value.type.icon,
                GlobalTime.convertDate(value.date),
                value.name,
                value.age,
                value.introduce
            )
        }

        fun create(value: UserEntity): UserItem {
            return UserItem(
                value.id,
                value.type.icon,
                GlobalTime.convertDate(value.date),
                value.name,
                value.age,
                value.introduce
            )
        }
    }
}
