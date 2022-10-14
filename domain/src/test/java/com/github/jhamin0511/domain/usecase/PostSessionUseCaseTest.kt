package com.github.jhamin0511.domain.usecase

import com.github.jhamin0511.domain.repository.FakeSessionRepository
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class PostSessionUseCaseTest {
    private val sessionRepository = FakeSessionRepository()
    private val useCase = PostSessionUseCase(sessionRepository)

    @Test
    fun postSession_errorEmail_throwUseCase() {
        // Given
        val email = ""
        val password = ""
        val token = "qwertyuiop[]asdfghjkl;'"
        // When
        val actual = useCase(email, password, token)
        // Then
        assertThat(actual.exceptionOrNull()?.message).isEqualTo("이메일 오류")
    }

    @Test
    fun postSession_errorPassword_throwUseCase() {
        // Given
        val email = "jhamin0511@gmail.com"
        val password = ""
        val token = "qwertyuiop[]asdfghjkl;'"
        // When
        val actual = useCase(email, password, token)
        // Then
        assertThat(actual.exceptionOrNull()?.message).isEqualTo("비밀번호 오류")
    }

    @Test
    fun postSession_success_assertEmail() {
        // Given
        val email = "jhamin0511@spendit.kr"
        val password = "asdfzxcv"
        val token = "qwertyuiop[]asdfghjkl;'"
        // When
        val actual = useCase(email, password, token)
        // Then
        assertThat(actual.getOrNull()?.email).isEqualTo(email)
    }
}
