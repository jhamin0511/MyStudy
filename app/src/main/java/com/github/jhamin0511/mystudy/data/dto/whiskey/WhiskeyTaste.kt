package com.github.jhamin0511.mystudy.data.dto.whiskey

import androidx.annotation.DrawableRes
import com.github.jhamin0511.mystudy.R
import com.google.gson.annotations.SerializedName

enum class WhiskeyTaste(
    @DrawableRes
    val imageRes: Int
) {
    @SerializedName("bad")
    BAD(R.drawable.ic_taste_1),
    @SerializedName("row")
    ROW(R.drawable.ic_taste_2),
    @SerializedName("middle")
    MIDDLE(R.drawable.ic_taste_3),
    @SerializedName("high")
    HIGH(R.drawable.ic_taste_4),
    @SerializedName("good")
    GOOD(R.drawable.ic_taste_5);

    companion object {
        fun rotate(current: WhiskeyTaste): WhiskeyTaste {
            return when (current) {
                BAD -> ROW
                ROW -> MIDDLE
                MIDDLE -> HIGH
                HIGH -> GOOD
                GOOD -> BAD
            }
        }
    }
}
