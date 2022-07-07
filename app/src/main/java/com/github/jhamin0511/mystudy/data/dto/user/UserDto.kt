package com.github.jhamin0511.mystudy.data.dto.user

import com.google.gson.annotations.SerializedName

data class UserDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("type")
    val type: UserType,
    @SerializedName("createAt")
    val createAt: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("introduce")
    val introduce: String
)
