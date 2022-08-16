package com.github.jhamin0511.mystudy.repository.user

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.database.AppDatabase
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.network.service.UserService
import com.github.jhamin0511.mystudy.ui.paging.KEY_COUNT
import com.github.jhamin0511.mystudy.ui.paging.START_PAGE
import java.io.IOException
import kotlinx.coroutines.delay
import retrofit2.HttpException
import timber.log.Timber

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
        Timber.i("load()")
        return try {
            currentKey = when (loadType) {
                LoadType.REFRESH -> {
                    Timber.i("LoadType.REFRESH")
                    START_PAGE
                }
                LoadType.PREPEND -> {
                    Timber.i("LoadType.PREPEND")
                    return MediatorResult.Success(true)
                }
                LoadType.APPEND -> {
                    Timber.i("LoadType.APPEND")
                    currentKey.plus(KEY_COUNT)
                }
            }
            val pageSize = if (loadType == LoadType.REFRESH) {
                state.config.initialLoadSize
            } else {
                state.config.pageSize
            }
            Timber.i("pageSize : $pageSize / loadType : $loadType/ currentKey : $currentKey")

            val response = service.getUsers(currentKey, pageSize)
            val users = UserEntity.create(response.users)
            delay(NETWORK_DELAY_TIME)

            database.withTransaction {
                Timber.i("database.withTransaction")
                if (loadType == LoadType.REFRESH) {
                    database.userDao().deleteAll()
                }
                database.userDao().insertAll(users)
            }

            MediatorResult.Success(response.last)
        } catch (e: IOException) {
            Timber.i("IOException : $e")
            MediatorResult.Error(e)
        } catch (e: HttpException) {
            Timber.i("HttpException : $e")
            MediatorResult.Error(e)
        }
    }
}
