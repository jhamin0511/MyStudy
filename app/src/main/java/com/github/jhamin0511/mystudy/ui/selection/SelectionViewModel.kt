package com.github.jhamin0511.mystudy.ui.selection

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.repository.food.FoodRepository
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class SelectionViewModel
@Inject constructor(
    private val repository: FoodRepository
) : ViewModel() {
    // region Binding
    val bindLoading = MutableLiveData<Boolean>()
    // endregion

    // region Observe
    val observeItems = MutableLiveData<Event<List<FoodItem>>>()
    // endregion

    // region Model
    fun callFoods() {
        viewModelScope.launch {
            bindLoading.value = true
            val items = repository.getFoods()
            delay(NETWORK_DELAY_TIME)
            observeItems.event(FoodItem.create(items))
            bindLoading.value = false
        }
    }
    // endregion
}
