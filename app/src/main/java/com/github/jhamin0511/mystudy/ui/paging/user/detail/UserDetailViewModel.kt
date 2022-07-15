package com.github.jhamin0511.mystudy.ui.paging.user.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.database.AppDatabase
import com.github.jhamin0511.mystudy.network.service.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class UserDetailViewModel
@Inject constructor(
    database: AppDatabase
) : ViewModel() {
    private val userDao = database.userDao()

    // region Binding
    val bindLoading = MutableLiveData<Boolean>()
    val bindPicture = MutableLiveData<Int>()
    val bindName = MutableLiveData<String>()
    val bindAge = MutableLiveData<Int>()
    val bindIntroduce = MutableLiveData<String>()
    val bindContent = MutableLiveData<String>()
    // endregion

    // region Observe
    val observeSaved = MutableLiveData<Event<Boolean>>()
    // endregion

    // region Model
    private var id: Long = 0

    fun initModel(args: UserDetailFragmentArgs) {
        id = args.id

        viewModelScope.launch {
            val entity = userDao.selectById(id)
            bindPicture.value = entity.type.icon
            bindName.value = entity.name
            bindAge.value = entity.age
            bindIntroduce.value = entity.introduce
            bindContent.value = entity.content
        }
    }

    fun save() {
        viewModelScope.launch {
            bindLoading.value = true

            userDao.update(
                id,
                System.currentTimeMillis(),
                bindIntroduce.value ?: "",
                bindContent.value ?: ""
            )

            delay(NETWORK_DELAY_TIME)

            observeSaved.event(true)
        }
    }
    // endregion
}
