package com.github.jhamin0511.domain.usecase

import com.github.jhamin0511.domain.model.Login
import com.github.jhamin0511.domain.model.User
import com.github.jhamin0511.domain.repository.SessionRepository

class PostSessionUseCase(
    private val sessionRepository: SessionRepository
) {
    operator fun invoke(email: String, password: String, token: String): Result<User> {
        val login = Login()

        return when {
            !login.validateEmail(email) -> Result.failure(UserCaseThrow("이메일 오류"))
            !login.validatePassword(password) -> Result.failure(UserCaseThrow("비밀번호 오류"))
            else -> Result.runCatching {
                sessionRepository.postSession(email, password, token)
            }
        }
    }
}
