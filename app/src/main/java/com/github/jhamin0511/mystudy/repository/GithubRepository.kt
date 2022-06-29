package com.github.jhamin0511.mystudy.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto
import kotlinx.coroutines.flow.Flow

private const val PER_PAGE = 30

class GithubRepository {
    fun getRepositories(): Flow<PagingData<GithubRepoDto>> {
        return Pager(
            config = PagingConfig(pageSize = PER_PAGE, enablePlaceholders = false),
            pagingSourceFactory = { GithubRepositoryPagingSource() }
        ).flow
    }
}
