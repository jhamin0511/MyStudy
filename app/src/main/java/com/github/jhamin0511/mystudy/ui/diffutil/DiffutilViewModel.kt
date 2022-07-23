package com.github.jhamin0511.mystudy.ui.diffutil

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.repository.whiskey.WhiskeyRepository
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import com.github.jhamin0511.mystudy.widget.recycler.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class DiffutilViewModel
@Inject constructor(
    private val repository: WhiskeyRepository
) : ViewModel() {
    // region Binding
    val bindLoading = MutableLiveData<Boolean>()
    // endregion

    // region Observe
    val observeItems = MutableLiveData<Event<List<Item>>>()
    // endregion

    // region Model
    fun callWhiskeys() {
        viewModelScope.launch {
            bindLoading.value = true
            val response = repository.getWhiskeys()
            val items = WhiskeyItem.create(response.whiskeys)
            delay(NETWORK_DELAY_TIME)
            observeItems.event(items)
            bindLoading.value = false
        }
    }
    // endregion
}
