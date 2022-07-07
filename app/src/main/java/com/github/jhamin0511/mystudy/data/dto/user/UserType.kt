package com.github.jhamin0511.mystudy.data.dto.user

import androidx.annotation.LayoutRes
import com.github.jhamin0511.mystudy.R
import com.google.gson.annotations.SerializedName

enum class UserType(
    @LayoutRes
    val icon: Int
) {
    @SerializedName("one")
    ONE(R.drawable.ic_face),

    @SerializedName("two")
    TWO(R.drawable.ic_face2),

    @SerializedName("three")
    THREE(R.drawable.ic_face3),

    @SerializedName("fore")
    FORE(R.drawable.ic_face4),

    @SerializedName("five")
    FIVE(R.drawable.ic_face5);

    companion object {
        fun getType(value: Int) = when (value % values().size) {
            ONE.ordinal -> ONE
            TWO.ordinal -> TWO
            THREE.ordinal -> THREE
            FORE.ordinal -> FORE
            FIVE.ordinal -> FIVE
            else -> throw IllegalArgumentException("not support type.")
        }
    }
}
