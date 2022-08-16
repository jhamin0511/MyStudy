package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.network.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {
    @GET("users")
    suspend fun getUsers(
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) perPage: Int
    ): UserResponse
}
