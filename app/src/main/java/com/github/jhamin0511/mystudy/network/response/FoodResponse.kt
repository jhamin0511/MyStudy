package com.github.jhamin0511.mystudy.network.response

import com.github.jhamin0511.mystudy.data.dto.food.FoodDto
import com.google.gson.annotations.SerializedName

data class FoodResponse(
    @SerializedName("totalCount")
    val total: Long,
    @SerializedName("items")
    val foods: List<FoodDto>
)
