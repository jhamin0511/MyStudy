package com.github.jhamin0511.mystudy.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.network.service.UserService
import java.io.IOException
import kotlinx.coroutines.delay
import retrofit2.HttpException
import timber.log.Timber

private const val START_PAGE = 1
private const val END_PAGE = 10
private const val KEY_COUNT = 1
private const val NETWORK_DELAY_TIME: Long = 500

class UserPagingSource(
    private val service: UserService
) : PagingSource<Int, UserDto>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserDto> {
        val page = params.key ?: START_PAGE
        Timber.i("load() / page : $page / params.loadSize : ${params.loadSize}")

        return try {
            val response = service.getUsers(page, params.loadSize)

            delay(NETWORK_DELAY_TIME)

            LoadResult.Page(
                data = response.users,
                prevKey = if (page == START_PAGE) {
                    null
                } else {
                    page.minus(KEY_COUNT)
                },
                nextKey = if (page == END_PAGE) {
                    null
                } else {
                    page.plus(KEY_COUNT)
                }
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserDto>): Int? {
        return state.anchorPosition?.let {
            val page = state.closestPageToPosition(it)
            page?.prevKey?.plus(KEY_COUNT) ?: page?.nextKey?.minus(KEY_COUNT)
        }
    }
}
