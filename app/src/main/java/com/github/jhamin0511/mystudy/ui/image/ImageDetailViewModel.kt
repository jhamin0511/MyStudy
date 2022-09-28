package com.github.jhamin0511.mystudy.ui.image

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ImageDetailViewModel
@Inject constructor() : ViewModel() {
    // region Binding
    val bindImage = MutableLiveData<Int>()
    // endregion

    // region Observe
    // endregion

    // region Model
    fun initModel(arg: ImageDetailFragmentArgs) {
        bindImage.value = arg.resource
    }
    // endregion
}
