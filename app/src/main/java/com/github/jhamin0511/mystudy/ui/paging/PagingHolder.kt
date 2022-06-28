package com.github.jhamin0511.mystudy.ui.paging

import android.view.View
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ItemDateBinding
import com.github.jhamin0511.mystudy.databinding.ItemUserBinding
import com.github.jhamin0511.mystudy.widget.recycler2.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler2.Item
import com.github.jhamin0511.mystudy.widget.recycler2.ItemClickListener

object PagingHolder {
    const val DATE = R.layout.item_date
    const val USER = R.layout.item_user
}

class DateHolder(
    view: View
) : BaseHolder<ItemDateBinding>(view) {

    override fun bind(item: Item) {
        binding.item = item as DateItem
    }
}

class UserHolder(
    view:View,
    private val listener: ItemClickListener<UserItem>
) : BaseHolder<ItemUserBinding>(view) {

    init {
        binding.root.setOnClickListener {
            listener.onClick(item, adapterPosition)
        }
    }

    lateinit var item: UserItem

    override fun bind(item: Item) {
        this.item = item as UserItem
        binding.item = item
    }
}
