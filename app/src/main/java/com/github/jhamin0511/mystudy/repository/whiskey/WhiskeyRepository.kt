package com.github.jhamin0511.mystudy.repository.whiskey

import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.network.request.WhiskeyRequest
import com.github.jhamin0511.mystudy.network.response.WhiskeysResponse
import com.github.jhamin0511.mystudy.network.service.WhiskeyService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WhiskeyRepository
@Inject constructor(
    private val service: WhiskeyService
) {
    suspend fun getWhiskeys(): WhiskeysResponse {
        return service.getWhiskeys()
    }

    suspend fun putWhiskey(request: WhiskeyRequest): WhiskeyDto {
        return service.putWhiskey(request).whiskey
    }
}
