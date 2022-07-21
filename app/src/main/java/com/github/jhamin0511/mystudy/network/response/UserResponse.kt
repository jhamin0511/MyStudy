package com.github.jhamin0511.mystudy.network.response

import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("totalCount")
    val total: Long,
    @SerializedName("items")
    val users: List<UserDto>,
    @SerializedName("last")
    val last: Boolean
)
