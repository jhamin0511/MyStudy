package com.github.jhamin0511.mystudy.data.dto.user

import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("type")
    val type: UserType = UserType.ONE,
    @SerializedName("createAt")
    val createAt: Long = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("age")
    val age: Int = 0,
    @SerializedName("introduce")
    val introduce: String = "",
    @SerializedName("content")
    val content: String = ""
) {
    companion object {
        fun create(entity: UserEntity): UserDto {
            return UserDto(
                entity.id,
                entity.type,
                entity.createAt,
                entity.name,
                entity.age,
                entity.introduce,
                entity.content,
            )
        }
    }
}
