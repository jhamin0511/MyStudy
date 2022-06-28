package com.github.jhamin0511.mystudy.widget.recycler

interface ItemLongClick {
    fun onLongClick(item: Item, position: Int): Boolean = true
}
