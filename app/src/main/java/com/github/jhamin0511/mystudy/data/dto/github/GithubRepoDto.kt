package com.github.jhamin0511.mystudy.data.dto.github

import com.google.gson.annotations.SerializedName

data class GithubRepoDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("html_url")
    val url: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("stargazers_count")
    val stars: Int,
    @SerializedName("forks_count")
    val forks: Int,
    @SerializedName("language")
    val language: String
)
