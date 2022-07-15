package com.github.jhamin0511.mystudy.repository.user

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.database.AppDatabase
import com.github.jhamin0511.mystudy.network.service.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.network.service.UserService
import java.io.IOException
import kotlinx.coroutines.delay
import retrofit2.HttpException
import timber.log.Timber

private const val START_PAGE = 1
private const val KEY_COUNT = 1

@OptIn(ExperimentalPagingApi::class)
class UserRemoteMediator(
    private val service: UserService,
    private val database: AppDatabase
) : RemoteMediator<Int, UserEntity>() {
    var currentKey = START_PAGE

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, UserEntity>
    ): MediatorResult {
        currentKey = when (loadType) {
            LoadType.REFRESH -> {
                START_PAGE
            }
            LoadType.PREPEND -> {
                return MediatorResult.Success(endOfPaginationReached = true)
            }
            LoadType.APPEND -> {
                currentKey.plus(KEY_COUNT)
            }
        }
        Timber.i("load() / loadKey : $currentKey / loadType : $loadType")

        return try {
            val perPage = when (loadType) {
                LoadType.REFRESH -> state.config.initialLoadSize
                else -> state.config.pageSize
            }
            val response = service.getUsers(currentKey, perPage)
            val users = UserEntity.create(response.users)

            delay(NETWORK_DELAY_TIME)

            database.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    database.userDao().deleteAll()
                }

                database.userDao().insertAll(users)
            }

            MediatorResult.Success(endOfPaginationReached = response.last)
        } catch (e: IOException) {
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            MediatorResult.Error(e)
        }
    }

    override suspend fun initialize(): InitializeAction {
        Timber.i("initialize()")
        return InitializeAction.LAUNCH_INITIAL_REFRESH
    }
}
