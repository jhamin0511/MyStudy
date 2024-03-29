package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.network.response.GithubRepositoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
    @GET("search/repositories?sort=stars")
    suspend fun getSearchRepository(
        @Query("q") keyword: String,
        @Query(PAGE) page: Int,
        @Query(PER_PAGE) perPage: Int = 30
    ): GithubRepositoryResponse
}
