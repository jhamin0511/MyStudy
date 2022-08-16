package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.network.response.AnimalsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimalService {

    @GET("animals")
    suspend fun getAnimals(
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) perPage: Int,
        @Query(SEARCH) search: String
    ): AnimalsResponse
}
