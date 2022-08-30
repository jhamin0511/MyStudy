package com.github.jhamin0511.mystudy.ui.paging.animal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.repository.animal.AnimalRepository
import com.github.jhamin0511.mystudy.ui.paging.START_PAGE
import com.github.jhamin0511.mystudy.viewmodel.value
import com.github.jhamin0511.mystudy.widget.recycler.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltViewModel
class AnimalViewModel
@Inject constructor(
    private val repository: AnimalRepository
) : ViewModel() {
    // region Binding
    val bindLoading = MutableLiveData(false)
    val bindEmpty = MutableLiveData<Boolean>()
    val bindSearch = MutableLiveData("")

    fun bindLoad() {
        Timber.i("bindLoad() : ${bindLoading.value()}")
        callItems(roadMore = true)
    }

    init {
        bindSearch.observeForever {
            Timber.i("bindSearch.observeForever() : $it")
            if (it.isNotEmpty()) {
                page = START_PAGE
                callItems(it)
            }
        }
    }
    // endregion

    // region Observe
    val observeItems = MutableLiveData<List<Item>>()
    // endregion

    // region Model
    private var page = START_PAGE
    private val dataSource = AnimalDataSource(observeItems)

    init {
        Timber.i("init")
        callItems()
    }

    private fun callItems(
        search: String = bindSearch.value(),
        roadMore: Boolean = false
    ) {
        Timber.i("callItems() / search : $search / roadMode : $roadMore")
        if (!bindLoading.value()) {
            viewModelScope.launch {
                bindLoading.value = true
                val response = repository.getAnimals(page++, search)
                delay(NETWORK_DELAY_TIME)
                if (roadMore) {
                    dataSource.addAll(response)
                } else {
                    dataSource.set(response)
                }
                bindEmpty.value = dataSource.isEmpty()
                bindLoading.value = false
            }
        }
    }
    // endregion
}
