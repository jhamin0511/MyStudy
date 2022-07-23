package com.github.jhamin0511.mystudy.repository.whiskey

import com.github.jhamin0511.mystudy.network.response.WhiskeyResponse
import com.github.jhamin0511.mystudy.network.service.WhiskeyService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WhiskeyRepository
@Inject constructor(
    private val service: WhiskeyService
) {
    suspend fun getWhiskeys(): WhiskeyResponse {
        return service.getWhiskeys()
    }
}
