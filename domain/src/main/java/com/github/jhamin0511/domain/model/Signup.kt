package com.github.jhamin0511.domain.model

import java.util.regex.Pattern

class Signup {
    companion object {
        private const val PASSWORD_MINIMUM_LENGTH = 8
    }

    fun validateName(name: String): Boolean {
        return name.isNotEmpty()
    }

    fun validateEmail(email: String): Boolean {
        return email.isNotEmpty()
    }

    fun validateEmailRegExp(email: String): Boolean {
        return Pattern.matches("[\\w\\~\\-\\.]+@[\\w\\~\\-]+(\\.[\\w\\~\\-]+)+$", email)
    }

    fun validatePassword(password: String): Boolean {
        return password.isNotEmpty()
    }

    fun validatePasswordLength(password: String): Boolean {
        return password.length >= PASSWORD_MINIMUM_LENGTH
    }

    fun validateConfirm(confirm: String): Boolean {
        return confirm.isNotEmpty()
    }

    fun validatePasswordAndConfirm(password: String, confirm: String): Boolean {
        return password == confirm
    }
}
