package com.github.jhamin0511.mystudy.repository

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto
import java.util.concurrent.TimeUnit
import kotlin.math.max
import kotlinx.coroutines.delay

private const val START_PAGE = 1
private const val DELAY_SECONDS_TIME = 4L

class GithubRepositoryPagingSource : PagingSource<Int, GithubRepoDto>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, GithubRepoDto> {
        val page = params.key ?: START_PAGE
        val range = page.until(page + params.loadSize)
        if (page != START_PAGE) delay(TimeUnit.SECONDS.toMillis(DELAY_SECONDS_TIME))

        return LoadResult.Page(
            data = range.map {
                GithubRepoDto(
                    it.toLong(),
                    "name : $it",
                    "description : $it",
                    "url : $it",
                    it,
                    it,
                    "language : $it"
                )
            },
            prevKey = when (page) {
                START_PAGE -> null
                else -> when (val prevKey = ensureValidKey(key = range.first - params.loadSize)) {
                    // We're at the start, there's nothing more to load
                    START_PAGE -> null
                    else -> prevKey
                }
            },
            nextKey = range.last + 1
        )
    }

    override fun getRefreshKey(state: PagingState<Int, GithubRepoDto>): Int? {
        var key: Int? = null
        val position = state.anchorPosition

        if (position != null) {
            val repository = state.closestItemToPosition(position)
            if (repository != null) {
                key = ensureValidKey(repository.id.toInt() - (state.config.pageSize / 2))
            }
        }

        return key
    }

    private fun ensureValidKey(key: Int) = max(START_PAGE, key)
}
