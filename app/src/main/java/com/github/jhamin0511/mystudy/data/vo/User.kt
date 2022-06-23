package com.github.jhamin0511.mystudy.data.vo

import androidx.annotation.DrawableRes

data class User(
    val id: Long,
    @DrawableRes
    val icon: Int,
    val createdAt: String,
    val name: String,
    val age: Int,
    val introduce: String
)
