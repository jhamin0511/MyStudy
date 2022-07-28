package com.github.jhamin0511.mystudy.ui.diffutil.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.time.GlobalTime
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import com.github.jhamin0511.mystudy.viewmodel.value
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class WhiskeyDetailViewModel
@Inject constructor(
    private val savedStateHandle: SavedStateHandle
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

            val whiskey = savedStateHandle.get<WhiskeyDto>("dto")
            Timber.i("init() / whiskey : ${whiskey}")
            if (whiskey != null) {
                id = whiskey.id
                date = whiskey.buyAt

                bindImage.value = whiskey.image
                bindDate.value = GlobalTime.convertDateTime(whiskey.buyAt)
                bindName.value = whiskey.name
                bindPrice.value = whiskey.price
                bindDescription.value = whiskey.description
                bindHistory.value = whiskey.history
                bindTaste.value = whiskey.taste
                bindBookmark.value = whiskey.bookmark
                bindFavorite.value = whiskey.favorite
                bindFollow.value = whiskey.follow
            }

            delay(NETWORK_DELAY_TIME)

            bindLoading.value = false
        }
    }
    // endregion

    // region Observe
    val observeShowPicker = MutableLiveData<Event<Long>>()
    val observeSaved = MutableLiveData<Event<WhiskeyDto>>()
    // endregion

    // region Model
    private var id: Long = 0
    private var date: Long = 0

    fun save() {
        viewModelScope.launch {
            bindLoading.value = true
            val dto = WhiskeyDto(
                id,
                date,
                bindImage.value(),
                bindName.value(),
                bindPrice.value(),
                bindDescription.value(),
                bindHistory.value(),
                bindTaste.value(),
                bindBookmark.value(),
                bindFavorite.value(),
                bindFollow.value()
            )
            delay(NETWORK_DELAY_TIME)

            bindLoading.value = false
            observeSaved.event(dto)
        }
    }

    fun applyDate(value: Long) {
        date = value
        bindDate.value = GlobalTime.convertDateTime(value)
    }
    // endregion
}
