package com.github.jhamin0511.mystudy.repository

import com.github.jhamin0511.mystudy.data.dto.food.FoodDto
import com.github.jhamin0511.mystudy.network.service.FoodService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FoodRepository
@Inject constructor(
    private val service: FoodService
) {

    suspend fun getFoods(): List<FoodDto> {
        return service.getFoods().foods
    }
}
