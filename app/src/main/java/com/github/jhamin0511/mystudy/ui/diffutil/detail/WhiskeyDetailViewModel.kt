package com.github.jhamin0511.mystudy.ui.diffutil.detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.time.GlobalTime
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import com.github.jhamin0511.mystudy.viewmodel.get
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class WhiskeyDetailViewModel
@Inject constructor(
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
        bindTaste.value = WhiskeyTaste.rotate(bindTaste.get())
    }

    fun bindClickBookmark() {
        bindBookmark.value = !bindBookmark.get()
    }

    fun bindClickFavorite() {
        bindFavorite.value = !bindFavorite.get()
    }

    fun bindClickFollow() {
        bindFollow.value = !bindFollow.get()
    }
    // endregion

    // region Observe
    val observeShowPicker = MutableLiveData<Event<Long>>()
    val observeSaved = MutableLiveData<Event<WhiskeyDto>>()
    // endregion

    // region Model
    private var id: Long = 0
    private var date: Long = 0

    fun initModel(args: WhiskeyDetailFragmentArgs) {
        viewModelScope.launch {
            bindLoading.value = true

            val whiskey = args.dto
            id = whiskey.uuid
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

            bindLoading.value = false
        }
    }

    fun save() {
        viewModelScope.launch {
            bindLoading.value = true
            val dto = WhiskeyDto(
                id,
                date,
                bindImage.get(),
                bindName.get(),
                bindPrice.get(),
                bindDescription.get(),
                bindHistory.get(),
                bindTaste.get(),
                bindBookmark.get(),
                bindFavorite.get(),
                bindFollow.get()
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
