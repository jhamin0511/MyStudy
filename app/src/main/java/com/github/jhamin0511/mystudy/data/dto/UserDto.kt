package com.github.jhamin0511.mystudy.data.dto

import androidx.annotation.DrawableRes

data class UserDto(
    val id: Long,
    @DrawableRes
    val icon: Int,
    val createdAt: String,
    val name: String,
    val age: Int,
    val introduce: String
)
