package com.github.jhamin0511.mystudy.ui.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.data.vo.BookVo
import com.github.jhamin0511.mystudy.key.ID
import com.github.jhamin0511.mystudy.key.VO
import com.github.jhamin0511.mystudy.network.request.BookEditRequest
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import com.github.jhamin0511.mystudy.viewmodel.value
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LivedataObjectViewModel
@Inject constructor(
    bundle: SavedStateHandle
) : ViewModel() {
    // region Binding
    val bindLoading = MutableLiveData<Boolean>()
    val bindBook = bundle.getLiveData<BookVo>(VO)
    // endregion

    // region Observe
    val observeSave = MutableLiveData<Event<BookEditRequest>>()
    // endregion

    // region Model
    private var id: Long = 0

    init {
        id = bundle.get(ID) ?: 0
    }

    fun save() {
        val request = BookEditRequest.create(bindBook.value())
        observeSave.event(request)
    }
    // endregion
}
