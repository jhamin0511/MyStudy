package com.github.jhamin0511.mystudy.repository.github

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto
import com.github.jhamin0511.mystudy.network.service.GithubService
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

private const val PER_PAGE = 30

@Singleton
class GithubRepository
@Inject constructor(
    private val service: GithubService
) {
    fun getGithubRepository(keyword: StateFlow<String>): Flow<PagingData<GithubRepoDto>> {
        return Pager(
            config = PagingConfig(pageSize = PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = {
                GithubReposPagingSource(service, keyword.value)
            }
        ).flow
    }
}
