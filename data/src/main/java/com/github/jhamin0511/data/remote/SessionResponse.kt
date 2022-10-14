package com.github.jhamin0511.data.remote

data class SessionResponse(
    val id: Long,
    val type: String,
    val email: String,
    val name: String,
    val age: Int,
    val address: String,
    val signupAt: String,
    val job: String
)
