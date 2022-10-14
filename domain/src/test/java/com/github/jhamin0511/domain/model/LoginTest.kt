package com.github.jhamin0511.domain.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class LoginTest {

    private val login = Login()

    @Test
    fun validateEmail_empty_assertFalse() {
        // Given
        val email = ""
        // When
        val actual = login.validateEmail(email)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_noneEmpty_assertTrue() {
        // Given
        val email = "user@spendit.kr"
        // When
        val actual = login.validateEmail(email)
        // Then
        assertThat(actual).isTrue()
    }

    @Test
    fun validatePassword_empty_assertFalse() {
        // Given
        val password = ""
        // When
        val actual = login.validatePassword(password)
        // Then
        assertThat(actual).isFalse()
    }
}
