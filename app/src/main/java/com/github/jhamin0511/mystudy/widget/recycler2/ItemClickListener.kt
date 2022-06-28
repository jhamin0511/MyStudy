package com.github.jhamin0511.mystudy.widget.recycler2

interface ItemClickListener<in ITEM : Item> {
    fun onClick(item: ITEM, position: Int)
    fun onLongClick(item: ITEM, position: Int): Boolean = false
}
