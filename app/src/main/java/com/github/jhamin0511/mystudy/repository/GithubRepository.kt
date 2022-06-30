package com.github.jhamin0511.mystudy.repository

import com.github.jhamin0511.mystudy.network.service.GithubService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubRepository
@Inject constructor(
    private val service: GithubService
) {
    fun getGithubRepositoryPagingSource(
        keyword: String
    ) = GithubRepositoryPagingSource(service, keyword)
}
