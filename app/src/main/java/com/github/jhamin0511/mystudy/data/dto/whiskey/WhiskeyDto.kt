package com.github.jhamin0511.mystudy.data.dto.whiskey

import androidx.annotation.DrawableRes
import com.google.gson.annotations.SerializedName

data class WhiskeyDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("buyAt")
    val buyAt: Long,
    @DrawableRes
    @SerializedName("image")
    val image: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("taste")
    val taste: WhiskeyTaste,
    @SerializedName("bookmark")
    val bookmark: Boolean,
    @SerializedName("favorite")
    val favorite: Boolean,
    @SerializedName("follow")
    val follow: Boolean,
    @SerializedName("checked")
    val checked: Boolean? = null
)
