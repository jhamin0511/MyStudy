package com.github.jhamin0511.mystudy.widget.recycler

interface AdapterItem<ITEM> {
    fun isEmpty(): Boolean
    fun add(e: ITEM)
    fun addAll(e: List<ITEM>)
    fun clear()
    fun remove(e: ITEM)
    fun remove(position: Int)
    fun get(position: Int): ITEM
}
