package com.github.jhamin0511.domain.repository

import com.github.jhamin0511.domain.model.User

interface SessionRepository {
    fun postSession(email: String, password: String, token: String) : User
}
