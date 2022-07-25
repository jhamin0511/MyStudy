package com.github.jhamin0511.mystudy.widget.recycler.source

import com.github.jhamin0511.mystudy.data.dto.Dto

abstract class DataSource<DATA : Dto> : SourceQuery<DATA> {
    protected val source = mutableListOf<DATA>()
    private val selectedSource = mutableListOf<Long>()

    abstract fun submit(values: List<DATA>)

    override fun get(id: Long): DATA? {
        return source.find { it.getId() == id }
    }

    override fun add(value: DATA) {
        source.add(value)
        submit(source)
    }

    override fun addAll(values: List<DATA>) {
        source.addAll(values)
        submit(source)
    }

    override fun remove(id: Long) {
        var findIndex = -1

        source.forEachIndexed { index, data ->
            if (data.getId() == id) {
                findIndex = index
                return@forEachIndexed
            }
        }

        source.removeAt(findIndex)
        submit(source)
    }

    override fun remove(value: DATA) {
        source.remove(value)
        submit(source)
    }

    override fun update(value: DATA) {
        var findIndex = -1

        source.forEachIndexed { index, data ->
            if (data.getId() == value.getId()) {
                findIndex = index
                return@forEachIndexed
            }
        }

        source[findIndex] = value
        submit(source)
    }

    override fun selected(id: Long): Boolean {
        val hasId = selectedSource.contains(id)

        if (hasId) {
            selectedSource.remove(id)
        } else {
            selectedSource.add(id)
        }

        return !hasId
    }

    fun getSelected(): List<Long> {
        return selectedSource
    }
}
