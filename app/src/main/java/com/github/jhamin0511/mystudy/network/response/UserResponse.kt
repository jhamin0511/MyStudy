package com.github.jhamin0511.mystudy.network.response

import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("total_count")
    val total: Long,
    @SerializedName("items")
    val users: List<UserDto>
)
