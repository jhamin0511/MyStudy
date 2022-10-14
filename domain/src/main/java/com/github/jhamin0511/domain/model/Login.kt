package com.github.jhamin0511.domain.model

class Login {
    fun validateEmail(email: String): Boolean {
        return email.isNotEmpty()
    }

    fun validatePassword(password: String): Boolean {
        return password.isNotEmpty()
    }
}
