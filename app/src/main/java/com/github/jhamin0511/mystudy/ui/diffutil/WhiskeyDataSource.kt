package com.github.jhamin0511.mystudy.ui.diffutil

import androidx.lifecycle.MutableLiveData
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.widget.source.DataSource

class WhiskeyDataSource(
    private val observe: MutableLiveData<List<Item>>
) : DataSource<WhiskeyDto>() {
    override fun submit(values: List<WhiskeyDto>) {
        val sorted = values.sortedByDescending { it.buyAt }
        val maps = sorted.map {
            val select = getSelected().contains(it.id)
            WhiskeyItem.create(it, select)
        }
        val group = maps.groupBy { it.buyAt }
        val list = group.flatMap {
            mutableListOf<Item>(WhiskeyHeaderItem(it.key)).apply {
                addAll(it.value)
            }
        }
        observe.value = list
    }
}
