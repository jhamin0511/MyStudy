package com.github.jhamin0511.mystudy.network.response

import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.google.gson.annotations.SerializedName

data class WhiskeyResponse(
    @SerializedName("totalCount")
    val total: Long,
    @SerializedName("items")
    val whiskeys: List<WhiskeyDto>
)
