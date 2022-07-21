package com.github.jhamin0511.mystudy.repository.github

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto
import com.github.jhamin0511.mystudy.network.service.GithubService
import com.github.jhamin0511.mystudy.ui.paging.KEY_COUNT
import com.github.jhamin0511.mystudy.ui.paging.START_PAGE
import okio.IOException
import retrofit2.HttpException
import timber.log.Timber

class GithubReposPagingSource(
    private val service: GithubService,
    private val keyword: String
) : PagingSource<Int, GithubRepoDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubRepoDto> {
        val page = params.key ?: START_PAGE
        Timber.i("load() page : ${page} / loadSize : ${params.loadSize}")

        return try {
            val response = service.getSearchRepository(keyword, page, params.loadSize)

            LoadResult.Page(
                data = response.items,
                prevKey = if (page == START_PAGE) {
                    null
                } else {
                    page.minus(KEY_COUNT)
                },
                nextKey = page.plus(KEY_COUNT)
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
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
