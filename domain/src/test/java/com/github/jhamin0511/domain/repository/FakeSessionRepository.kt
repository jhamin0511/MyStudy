package com.github.jhamin0511.domain.repository

import com.github.jhamin0511.domain.model.User

class FakeSessionRepository : SessionRepository {
    companion object {
        val FAKE_USER = User(
            id = 12345678,
            email = "",
            name = "정하민",
            age = 31,
            address = "서울 성동구",
            job = "개발자"
        )
    }

    private var shouldReturnError = false

    fun setReturnError(value: Boolean) {
        shouldReturnError = value
    }

    override fun postSession(email: String, password: String, token: String): User {
        if (shouldReturnError) {
            throw RepositoryThrow("로그인 실패")
        }

        return FAKE_USER.copy(email = email)
    }
}
