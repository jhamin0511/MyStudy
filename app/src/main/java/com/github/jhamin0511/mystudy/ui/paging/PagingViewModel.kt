package com.github.jhamin0511.mystudy.ui.paging

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.insertSeparators
import androidx.paging.map
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.repository.paging.PagingRepository
import com.github.jhamin0511.mystudy.widget.recycler.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.map

fun PagingData<UserDto>.transformItem(): PagingData<Item> {
    return this.map { dto ->
        PagingItem.createUser(dto)
    }.insertSeparators { before, after ->
        val firstDate = before == null && after != null
        val restDate = before is UserItem &&
                after is UserItem &&
                before.createdAt != after.createdAt
        if (firstDate || restDate) {
            DateItem((after as UserItem).createdAt)
        } else {
            null
        }
    }
}

@HiltViewModel
class PagingViewModel
@Inject constructor(
    private val repository: PagingRepository
) : ViewModel() {
    // region Binding
    // endregion

    // region Observe
    fun observerUserPagingSource(): LiveData<PagingData<Item>> {
        return repository.getUsersPagingSource().flow
            .map {
                transformItem(it)
            }
            .cachedIn(viewModelScope)
            .asLiveData()
    }
    // endregion

    // region Model
    @VisibleForTesting
    fun transformItem(value: PagingData<UserDto>): PagingData<Item> {
        return value.map { dto ->
            PagingItem.createUser(dto)
        }.insertSeparators { before, after ->
            val firstDate = before == null && after != null
            val restDate = before is UserItem &&
                    after is UserItem &&
                    before.createdAt != after.createdAt
            if (firstDate || restDate) {
                DateItem((after as UserItem).createdAt)
            } else {
                null
            }
        }
    }
    // endregion
}
