package com.github.jhamin0511.domain.model

data class User(
    val id: Long,
    val email: String,
    val name: String,
    val age: Int,
    val address: String,
    val job: String
)
