package com.github.jhamin0511.data.remote

interface SessionService {
    fun postSession(request: SessionRequest): SessionResponse
}
