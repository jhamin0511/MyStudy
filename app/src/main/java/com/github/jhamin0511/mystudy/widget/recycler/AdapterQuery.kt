package com.github.jhamin0511.mystudy.widget.recycler

interface AdapterQuery {
    fun size(): Int
    fun isEmptyItem(): Boolean
    fun getItem(position: Int): AdapterItem
    fun getItems(): List<AdapterItem>
    fun addItem(e: AdapterItem)
    fun addItems(e: List<AdapterItem>)
    fun clearItem()
    fun removeItem(e: AdapterItem)
    fun removeItem(position: Int)
}
