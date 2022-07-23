package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.network.response.WhiskeyResponse
import retrofit2.http.GET

interface WhiskeyService {

    @GET("whiskeys")
    suspend fun getWhiskeys(): WhiskeyResponse
}
