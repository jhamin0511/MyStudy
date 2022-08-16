package com.github.jhamin0511.mystudy.data.vo

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class BookVo(
    val id: Long,
    @DrawableRes
    val image: Int,
    val name: String,
    val title: String,
    val author: String,
    val translator: String,
    val publisher: String,
    var introduce: String
) : Parcelable
