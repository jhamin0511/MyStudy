package com.github.jhamin0511.mystudy.data.dto.github

data class GithubRepoDto(
    val id: Long,
    val name: String,
    val description: String?,
    val url: String,
    val stars: Int,
    val forks: Int,
    val language: String?
)
