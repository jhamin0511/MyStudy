package com.github.jhamin0511.mystudy.ui.paging.user

import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ItemDateBinding
import com.github.jhamin0511.mystudy.databinding.ItemUserBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick
import com.github.jhamin0511.mystudy.widget.recycler.ItemLongClick

object PagingHolder {
    const val DATE = R.layout.item_date
    const val USER = R.layout.item_user
}

class DateHolder(
    private val binding: ItemDateBinding
) : BaseHolder(binding.root) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as DateItem
    }
}

class UserHolder(
    private val binding: ItemUserBinding,
    click: ItemClick,
    longClick: ItemLongClick
) : BaseHolder(binding.root, click, longClick) {
    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as UserItem
    }
}
