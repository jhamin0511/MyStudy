package com.github.jhamin0511.mystudy.ui.paging.user

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import androidx.paging.map
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.repository.user.UserRepository
import com.github.jhamin0511.mystudy.ui.common.recycler.DateItem
import com.github.jhamin0511.mystudy.widget.recycler.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.map

@HiltViewModel
class UserViewModel
@Inject constructor(
    private val repository: UserRepository
) : ViewModel() {
    // region Binding
    // endregion

    // region Observe
    private val type = MutableLiveData(UserPagingType.NETWORK)

    val observeItems = type.map {
        when (it) {
            UserPagingType.NETWORK -> repository.getUsersOnlyNetworkPagingSource()
            UserPagingType.DATABASE -> repository.getUserOnlyDatabasePagingSource()
            UserPagingType.NET_DB -> repository.getUsersNetDbPagingSource()
            else -> throw IllegalArgumentException("not support type.")
        }.flow
            .map { pagingData -> transformItem(pagingData) }
            .cachedIn(viewModelScope)
    }
    // endregion

    // region Model
    fun setType(type: UserPagingType) {
        this.type.value = type
    }

    fun getType(): UserPagingType {
        return type.value ?: UserPagingType.NETWORK
    }

    @VisibleForTesting
    fun transformItem(value: PagingData<UserEntity>): PagingData<Item> {
        return value.map { dto ->
            UserItem.create(dto)
        }.insertSeparators { before, after ->
            val firstDate = before == null && after != null
            val restDate = before is UserItem &&
                after is UserItem &&
                before.date != after.date
            if (firstDate || restDate) {
                DateItem((after as UserItem).date)
            } else {
                null
            }
        }
    }
    // endregion
}
