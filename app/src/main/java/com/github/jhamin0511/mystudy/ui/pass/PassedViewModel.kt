package com.github.jhamin0511.mystudy.ui.pass

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.app.common.viewmodel.Event
import com.github.jhamin0511.app.common.viewmodel.event
import com.github.jhamin0511.app.common.viewmodel.value
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.key.DTO
import com.github.jhamin0511.mystudy.time.GlobalTime
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class PassedViewModel
@Inject constructor(
    handle: SavedStateHandle
) : ViewModel() {
    // region Binding
    val bindLoading = MutableLiveData<Boolean>()
    val bindImage = MutableLiveData<Int>()
    val bindDate = MutableLiveData<String>()
    val bindName = MutableLiveData<String>()
    val bindPrice = MutableLiveData<String>()
    val bindDescription = MutableLiveData<String>()
    val bindHistory = MutableLiveData<String>()
    val bindTaste = MutableLiveData<WhiskeyTaste>()
    val bindBookmark = MutableLiveData<Boolean>()
    val bindFavorite = MutableLiveData<Boolean>()
    val bindFollow = MutableLiveData<Boolean>()

    fun bindClickDate() {
        observeShowPicker.event(date)
    }

    fun bindClickTaste() {
        bindTaste.value = WhiskeyTaste.rotate(bindTaste.value())
    }

    fun bindClickBookmark() {
        bindBookmark.value = !bindBookmark.value()
    }

    fun bindClickFavorite() {
        bindFavorite.value = !bindFavorite.value()
    }

    fun bindClickFollow() {
        bindFollow.value = !bindFollow.value()
    }

    init {
        viewModelScope.launch {
            bindLoading.value = true

            handle.get<WhiskeyDto>(DTO)?.let {
                id = it.id
                date = it.buyAt

                bindImage.value = it.image
                bindDate.value = GlobalTime.convertDateTime(it.buyAt)
                bindName.value = it.name
                bindPrice.value = it.price
                bindDescription.value = it.description
                bindHistory.value = it.history
                bindTaste.value = it.taste
                bindBookmark.value = it.bookmark
                bindFavorite.value = it.favorite
                bindFollow.value = it.follow
            }

            delay(NETWORK_DELAY_TIME)

            bindLoading.value = false
        }
    }
    // endregion

    // region Observe
    val observeShowPicker = MutableLiveData<Event<Long>>()
    // endregion

    // region Model
    private var id: Long = 0
    private var date: Long = 0
    // endregion
}
