package com.github.jhamin0511.mystudy.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto
import com.github.jhamin0511.mystudy.network.service.GithubService
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber

private const val START_PAGE = 1
private const val KEY_COUNT = 1

class GithubRepositoryPagingSource(
    private val service: GithubService,
    private val keyword: String
) : PagingSource<Int, GithubRepoDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubRepoDto> {
        val page = params.key ?: START_PAGE

        return try {
            val response = service.getSearchRepository(page, params.loadSize, keyword)

            LoadResult.Page(
                data = response.items,
                prevKey = when (page) {
                    START_PAGE -> null
                    else -> page.minus(KEY_COUNT)
                },
                nextKey = page.plus(KEY_COUNT)
            )
        } catch (exception: IOException) {
            Timber.e(exception)
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            Timber.e(exception)
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, GithubRepoDto>): Int? {
        return state.anchorPosition?.let {
            val page = state.closestPageToPosition(it)
            page?.prevKey?.plus(KEY_COUNT) ?: page?.nextKey?.minus(KEY_COUNT)
        }
    }
}
