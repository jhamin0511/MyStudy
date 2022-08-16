package com.github.jhamin0511.mystudy.ui.paging.animal

import androidx.lifecycle.MutableLiveData
import com.github.jhamin0511.mystudy.data.dto.animal.AnimalDto
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.source.DataSource

class AnimalDataSource(
    private val liveData: MutableLiveData<List<Item>>
) : DataSource<AnimalDto>() {
    override fun submit(values: List<AnimalDto>) {
        liveData.value = AnimalItem.create(values)
    }
}
