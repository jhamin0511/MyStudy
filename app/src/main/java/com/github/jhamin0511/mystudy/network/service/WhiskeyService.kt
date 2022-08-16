package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.network.request.WhiskeyRequest
import com.github.jhamin0511.mystudy.network.response.WhiskeyResponse
import com.github.jhamin0511.mystudy.network.response.WhiskeysResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT

interface WhiskeyService {

    @GET("whiskeys")
    suspend fun getWhiskeys(): WhiskeysResponse

    @PUT("whiskey")
    suspend fun putWhiskey(
        @Body request: WhiskeyRequest
    ): WhiskeyResponse
}
