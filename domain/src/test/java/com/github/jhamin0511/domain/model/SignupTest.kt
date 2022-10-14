package com.github.jhamin0511.domain.model

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SignupTest {

    private val signup = Signup()

    @Test
    fun validateName_empty_assertFalse() {
        // Given
        val name = ""
        // When
        val actual = signup.validateName(name)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validateName_noneEmpty_assertTrue() {
        // Given
        val name = ""
        // When
        val actual = signup.validateName(name)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_empty_assertFalse() {
        // Given
        val email = ""
        // When
        val actual = signup.validateEmail(email)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmail_noneEmpty_assertFalse() {
        // Given
        val email = ""
        // When
        val actual = signup.validateEmail(email)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmailRegExp_empty_assertFalse() {
        // Given
        val email = ""
        // When
        val actual = signup.validateEmailRegExp(email)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validateEmailRegExp_correct_assertTrue() {
        // Given
        val email = "user@gmail.com"
        // When
        val actual = signup.validateEmailRegExp(email)
        // Then
        assertThat(actual).isTrue()
    }

    @Test
    fun validateEmailRegExp_incorrect_assertFalse() {
        // Given
        val email = "user@gmailcom"
        // When
        val actual = signup.validateEmailRegExp(email)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePassword_empty_assertFalse() {
        // Given
        val password = ""
        // When
        val actual = signup.validatePassword(password)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePassword_noneEmpty_assertTrue() {
        // Given
        val password = "1234567"
        // When
        val actual = signup.validatePassword(password)
        // Then
        assertThat(actual).isTrue()
    }

    @Test
    fun validatePasswordLength_LessThenEightLength_assertFalse() {
        // Given
        val password = "1234567"
        // When
        val actual = signup.validatePasswordLength(password)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePasswordLength_OverThenEightLength_assertTrue() {
        // Given
        val password = "123456789"
        // When
        val actual = signup.validatePasswordLength(password)
        // Then
        assertThat(actual).isTrue()
    }

    @Test
    fun validateConfirm_empty_assertFalse() {
        // Given
        val confirm = ""
        // When
        val actual = signup.validateConfirm(confirm)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validateConfirm_noneEmpty_assertFalse() {
        // Given
        val confirm = "12345678"
        // When
        val actual = signup.validateConfirm(confirm)
        // Then
        assertThat(actual).isTrue()
    }

    @Test
    fun validatePasswordConfirm_notSame_assertFalse() {
        // Given
        val password = "12345678"
        val confirm = "123456789"
        // When
        val actual = signup.validatePasswordAndConfirm(password = password, confirm = confirm)
        // Then
        assertThat(actual).isFalse()
    }

    @Test
    fun validatePasswordConfirm_same_assertFalse() {
        // Given
        val password = "12345678"
        val confirm = "12345678"
        // When
        val actual = signup.validatePasswordAndConfirm(password = password, confirm = confirm)
        // Then
        assertThat(actual).isTrue()
    }
}
