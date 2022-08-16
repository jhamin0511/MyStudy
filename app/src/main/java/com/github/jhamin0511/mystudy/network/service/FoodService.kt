package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.network.response.FoodResponse
import retrofit2.http.GET

interface FoodService {
    @GET("foods")
    suspend fun getFoods(): FoodResponse
}
