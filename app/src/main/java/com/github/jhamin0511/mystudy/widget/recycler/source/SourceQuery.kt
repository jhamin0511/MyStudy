package com.github.jhamin0511.mystudy.widget.recycler.source

import com.github.jhamin0511.mystudy.data.dto.Dto

interface SourceQuery<DATA : Dto> {
    fun get(id: Long): DATA?
    fun add(value: DATA)
    fun addAll(values: List<DATA>)
    fun remove(id: Long)
    fun remove(value: DATA)
    fun update(value: DATA)
    /**
     * @return true 이면 선택, false이면 해제
     *  */
    fun selected(id: Long): Boolean
}
