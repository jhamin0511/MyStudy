package com.github.jhamin0511.mystudy.ui.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.data.vo.BookVo
import com.github.jhamin0511.mystudy.key.VO
import com.github.jhamin0511.mystudy.network.request.BookEditRequest
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LivedataExtractViewModel
@Inject constructor(
    bundle: SavedStateHandle
) : ViewModel() {
    // region Binding
    val bindLoading = MutableLiveData<Boolean>()
    val bindImage = MutableLiveData<Int>()
    val bindName = MutableLiveData<String>()
    val bindTitle = MutableLiveData<String>()
    val bindAuthor = MutableLiveData<String>()
    val bindTranslator = MutableLiveData<String>()
    val bindPublisher = MutableLiveData<String>()
    val bindIntroduce = MutableLiveData<String>()

    init {
        bundle.get<BookVo>(VO)?.let {
            id = it.id
            bindImage.value = it.image
            bindName.value = it.name
            bindTitle.value = it.title
            bindAuthor.value = it.author
            bindTranslator.value = it.translator
            bindPublisher.value = it.publisher
            bindIntroduce.value = it.introduce
        }
    }
    // endregion

    // region Observe
    val observeSave = MutableLiveData<Event<BookEditRequest>>()
    // endregion

    // region Model
    private var id: Long = 0

    fun save() {
        val request = BookEditRequest(
            bindName.value ?: "",
            bindTitle.value ?: "",
            bindAuthor.value ?: "",
            bindTranslator.value ?: "",
            bindPublisher.value ?: "",
            bindIntroduce.value ?: ""
        )
        observeSave.event(request)
    }
    // endregion
}
