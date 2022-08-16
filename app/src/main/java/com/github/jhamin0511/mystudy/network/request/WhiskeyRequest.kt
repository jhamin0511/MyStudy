package com.github.jhamin0511.mystudy.network.request

import androidx.annotation.DrawableRes
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.google.gson.annotations.SerializedName

data class WhiskeyRequest(
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
    @SerializedName("history")
    val history: String,
    @SerializedName("taste")
    val taste: WhiskeyTaste = WhiskeyTaste.BAD,
    @SerializedName("bookmark")
    val bookmark: Boolean = false,
    @SerializedName("favorite")
    val favorite: Boolean = false,
    @SerializedName("follow")
    val follow: Boolean = false
)
