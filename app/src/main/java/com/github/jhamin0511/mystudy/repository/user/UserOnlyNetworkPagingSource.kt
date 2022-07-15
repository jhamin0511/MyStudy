package com.github.jhamin0511.mystudy.repository.user

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.network.service.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.network.service.UserService
import java.io.IOException
import kotlinx.coroutines.delay
import retrofit2.HttpException
import timber.log.Timber

private const val START_PAGE = 1
private const val KEY_COUNT = 1

class UserOnlyNetworkPagingSource(
    private val service: UserService
) : PagingSource<Int, UserEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UserEntity> {
        Timber.i("load() / params : $params")

        return try {
            val currentKey = params.key ?: START_PAGE
            val response = service.getUsers(currentKey, params.loadSize)

            delay(NETWORK_DELAY_TIME)

            val prevKey = null
            val nextKey = if (response.last) {
                null
            } else {
                currentKey.plus(KEY_COUNT)
            }
            Timber.i("load() / prevKey = $prevKey / currentKey : $currentKey / nextKey = $nextKey")

            LoadResult.Page(
                data = UserEntity.create(response.users),
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, UserEntity>): Int? {
        Timber.i("getRefreshKey() / state.anchorPosition : ${state.anchorPosition}")
        val key = state.anchorPosition?.let {
            val page = state.closestPageToPosition(it)
            Timber.i("getRefreshKey() / prevKey : ${page?.prevKey} / nextKey : ${page?.nextKey}")
            page?.prevKey?.plus(KEY_COUNT) ?: page?.nextKey?.minus(KEY_COUNT)
        }
        Timber.i("getRefreshKey() / key : $key")
        return null
    }
}
