package com.github.jhamin0511.data.remote

import com.github.jhamin0511.data.dto.UserDto
import com.github.jhamin0511.data.source.SessionDataSource

class SessionRemoteDataSource(private val service: SessionService) : SessionDataSource {
    override fun postSession(email: String, password: String, token: String): UserDto {
        val request = SessionRequest(email, password, token)
        val response = service.postSession(request)

        return UserDto(
            response.id,
            response.email,
            response.name,
            response.age,
            response.address,
            response.job
        )
    }
}
