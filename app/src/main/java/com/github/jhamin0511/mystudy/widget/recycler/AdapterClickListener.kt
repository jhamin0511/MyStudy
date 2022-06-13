package com.github.jhamin0511.mystudy.widget.recycler

interface AdapterClickListener<ITEM> {
    fun onClickListener(position: Int, item: ITEM)
    fun onLongClickListener(position: Int, item: ITEM) = false
}
