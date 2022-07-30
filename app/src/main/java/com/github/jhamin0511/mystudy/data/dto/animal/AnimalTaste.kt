package com.github.jhamin0511.mystudy.data.dto.animal

import androidx.annotation.StringRes
import com.github.jhamin0511.mystudy.R
import com.google.gson.annotations.SerializedName

enum class AnimalTaste(
    @StringRes
    val value: Int
) {
    /** 초식 */
    @SerializedName("herbivores")
    HERBIVORES(R.string.herbivores),

    /** 육식 */
    @SerializedName("carnivores")
    CARNIVORES(R.string.carnivores),

    /** 잡식 */
    @SerializedName("omnivores")
    OMNIVORES(R.string.omnivores);
}
