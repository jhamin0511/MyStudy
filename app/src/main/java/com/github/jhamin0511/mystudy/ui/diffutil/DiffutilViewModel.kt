package com.github.jhamin0511.mystudy.ui.diffutil

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.network.request.WhiskeyRequest
import com.github.jhamin0511.mystudy.repository.whiskey.WhiskeyRepository
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

    fun bindClickAdd() {
        viewModelScope.launch {
            bindLoading.value = true
            addCount++
            val request = WhiskeyRequest(
                System.currentTimeMillis(),
                R.drawable.img_1792smallbatch,
                "$addCount 위스키",
                addCount.toString(),
                "$addCount Description",
                "$addCount History"
            )
            val whiskey = repository.putWhiskey(request)
            delay(NETWORK_DELAY_TIME)
            dataSource.add(whiskey)
            bindLoading.value = false
        }
    }
    // endregion

    // region Observe
    val observeItems = MutableLiveData<List<Item>>()
    // endregion

    // region Model
    val dataSource = WhiskeyDataSource(observeItems)
    private var addCount = 1

    init {
        callWhiskeys()
    }

    private fun callWhiskeys() {
        viewModelScope.launch {
            bindLoading.value = true
            val response = repository.getWhiskeys()
            delay(NETWORK_DELAY_TIME)
            dataSource.addAll(response.whiskeys)
            bindLoading.value = false
        }
    }
    // endregion
}
