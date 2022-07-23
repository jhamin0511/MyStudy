package com.github.jhamin0511.mystudy.ui.paging.user.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.database.AppDatabase
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.time.GlobalTime
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
    val bindDate = MutableLiveData<String>()
    val bindIntroduce = MutableLiveData<String>()
    val bindContent = MutableLiveData<String>()

    fun bindClickDate() {
        viewModelScope.launch {
            val date = userDao.selectDateById(id)
            observeShowPicker.event(date)
        }
    }
    // endregion

    // region Observe
    val observeSaved = MutableLiveData<Event<Boolean>>()
    val observeShowPicker = MutableLiveData<Event<Long>>()
    // endregion

    // region Model
    private var id: Long = 0
    private var date: Long = 0

    fun initModel(args: UserDetailFragmentArgs) {
        id = args.id

        viewModelScope.launch {
            val entity = userDao.selectById(id) ?: UserEntity(
                id,
                UserType.ONE,
                System.currentTimeMillis(),
                "new name $id",
                id.toInt(),
                "new introduce $id",
                "new content $id"
            )
            date = entity.date

            bindPicture.value = entity.type.icon
            bindName.value = entity.name
            bindAge.value = entity.age
            bindDate.value = GlobalTime.convertDateTime(entity.date)
            bindIntroduce.value = entity.introduce
            bindContent.value = entity.content
        }
    }

    fun save() {
        viewModelScope.launch {
            bindLoading.value = true

            userDao.update(
                id,
                date,
                bindIntroduce.value ?: "",
                bindContent.value ?: ""
            )

            delay(NETWORK_DELAY_TIME)

            observeSaved.event(true)
        }
    }

    fun applyDate(value: Long) {
        date = value
        bindDate.value = GlobalTime.convertDateTime(value)
    }
    // endregion
}
