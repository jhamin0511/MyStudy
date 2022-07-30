package com.github.jhamin0511.mystudy.network.response

import com.github.jhamin0511.mystudy.data.dto.animal.AnimalDto
import com.google.gson.annotations.SerializedName

data class AnimalsResponse(
    @SerializedName("total_count")
    val total: Int,
    @SerializedName("items")
    val animals: List<AnimalDto>,
    @SerializedName("last")
    val last: Boolean
)
