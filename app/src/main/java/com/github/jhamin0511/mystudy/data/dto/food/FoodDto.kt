package com.github.jhamin0511.mystudy.data.dto.food

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class FoodDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("price")
    val price: String,
    @DrawableRes
    @SerializedName("image")
    val image: Int,
    @SerializedName("description")
    val description: String,
    @SerializedName("favoriteCount")
    val favoriteCount: Int,
    @SerializedName("bookmarkCount")
    val bookmarkCount: Int,
    @SerializedName("followCount")
    val followCount: Int
)
