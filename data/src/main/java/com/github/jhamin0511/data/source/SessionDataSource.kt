package com.github.jhamin0511.data.source

import com.github.jhamin0511.data.dto.UserDto

interface SessionDataSource {
    fun postSession(email: String, password: String, token: String): UserDto
}
