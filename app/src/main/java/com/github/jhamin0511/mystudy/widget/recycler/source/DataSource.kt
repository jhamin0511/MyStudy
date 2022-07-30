package com.github.jhamin0511.mystudy.widget.recycler.source

import com.github.jhamin0511.mystudy.data.dto.Dto

@Suppress("TooManyFunctions")
abstract class DataSource<DATA : Dto> : SourceQuery<DATA> {
    companion object {
        private const val INIT_INDEX = -1
    }

    protected val source = mutableListOf<DATA>()
    private val selectedSource = mutableListOf<Long>()

    abstract fun submit(values: List<DATA>)

    override fun get(id: Long): DATA? {
        return source.find { it.id() == id }
    }

    override fun set(values: List<DATA>) {
        source.clear()
        source.addAll(values)
        submit(source)
    }

    override fun add(value: DATA) {
        source.add(value)
        submit(source)
    }

    override fun addAll(values: List<DATA>) {
        source.addAll(values)
        submit(source)
    }

    override fun remove(id: Long): DATA? {
        var findIndex = INIT_INDEX

        source.forEachIndexed { index, data ->
            if (data.id() == id) {
                findIndex = index
                return@forEachIndexed
            }
        }

        var removeData: DATA? = null

        if (findIndex != INIT_INDEX) {
            removeData = source.removeAt(findIndex)
            submit(source)
            removeSelect(id)
        }

        return removeData
    }

    private fun removeSelect(id: Long) {
        val hasId = selectedSource.contains(id)

        if (hasId) {
            selectedSource.remove(id)
        }
    }

    override fun update(value: DATA): DATA? {
        var findIndex = INIT_INDEX

        source.forEachIndexed { index, data ->
            if (data.id() == value.id()) {
                findIndex = index
                return@forEachIndexed
            }
        }

        var updateData: DATA? = null

        if (findIndex != INIT_INDEX) {
            updateData = source.set(findIndex, value)
            submit(source)
        }

        return updateData
    }

    override fun clear() {
        source.clear()
        submit(source)
    }

    override fun size(): Int {
        return source.size
    }

    override fun isEmpty(): Boolean {
        return source.isEmpty()
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
