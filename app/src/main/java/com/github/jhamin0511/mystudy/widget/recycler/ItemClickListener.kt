package com.github.jhamin0511.mystudy.widget.recycler

interface ItemClickListener {
    fun onClickListener(position: Int, item: BaseItem<*>)
    fun onLongClickListener(position: Int, item: BaseItem<*>) = false
}
