package com.github.jhamin0511.mystudy.network.response

import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto
import com.google.gson.annotations.SerializedName

data class GithubRepositoryResponse(
    @SerializedName("total_count")
    val total: Int,
    @SerializedName("items")
    val items: List<GithubRepoDto>
)
