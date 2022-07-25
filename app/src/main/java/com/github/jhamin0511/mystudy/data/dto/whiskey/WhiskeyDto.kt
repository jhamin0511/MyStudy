package com.github.jhamin0511.mystudy.data.dto.whiskey

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.github.jhamin0511.mystudy.data.dto.Dto
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class WhiskeyDto(
    @SerializedName("id")
    val uuid: Long,
    @SerializedName("buyAt")
    var buyAt: Long,
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
    var taste: WhiskeyTaste,
    @SerializedName("bookmark")
    var bookmark: Boolean,
    @SerializedName("favorite")
    var favorite: Boolean,
    @SerializedName("follow")
    var follow: Boolean
) : Parcelable, Dto {
    override fun getId(): Long {
        return uuid
    }
}
