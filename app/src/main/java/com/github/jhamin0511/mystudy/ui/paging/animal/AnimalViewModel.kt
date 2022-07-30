package com.github.jhamin0511.mystudy.ui.paging.animal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.jhamin0511.mystudy.di.network.NETWORK_DELAY_TIME
import com.github.jhamin0511.mystudy.repository.animal.AnimalRepository
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
    val bindLoading = MutableLiveData<Boolean>()
    val bindEmpty = MutableLiveData<Boolean>()
    val bindSearch = MutableLiveData<String>()

    fun bindLoad() {
        Timber.i("bindLoad() : ${bindLoading.value(false)}")
        if (bindLoading.value == false) {
            viewModelScope.launch {
                bindLoading.value = true
                val response = repository.getAnimals(page++, bindSearch.value(""))
                delay(NETWORK_DELAY_TIME)
                dataSource.addAll(response)
                bindEmpty.value = dataSource.isEmpty()
                bindLoading.value = false
            }
        }
    }

    init {
        bindSearch.observeForever {
            Timber.i("bindSearch.observeForever() : $it")
            page = 1
            callInitialItems(it)
        }
    }
    // endregion

    // region Observe
    val observeItems = MutableLiveData<List<Item>>()
    // endregion

    // region Model
    private var page = 1
    val dataSource = AnimalDataSource(observeItems)

    init {
        Timber.i("init")
        callInitialItems("")
    }

    private fun callInitialItems(
        search: String = bindSearch.value()
    ) {
        viewModelScope.launch {
            bindLoading.value = true
            val response = repository.getAnimals(page++, search)
            delay(NETWORK_DELAY_TIME)
            dataSource.set(response)
            bindEmpty.value = dataSource.isEmpty()
            bindLoading.value = false
        }
    }
    // endregion
}
