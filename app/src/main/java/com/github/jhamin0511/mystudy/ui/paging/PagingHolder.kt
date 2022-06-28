package com.github.jhamin0511.mystudy.ui.paging

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ItemDateBinding
import com.github.jhamin0511.mystudy.databinding.ItemUserBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick

object PagingHolder {
    const val DATE = R.layout.item_date
    const val USER = R.layout.item_user
}

class DateHolder(
    view: View
) : BaseHolder(view) {
    private val binding: ItemDateBinding = DataBindingUtil.bind(view)!!

    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as DateItem
    }
}

class UserHolder(
    view: View,
    onClick: ItemClick
) : BaseHolder(view, onClick) {
    private val binding: ItemUserBinding = DataBindingUtil.bind(view)!!

    override fun bind(item: Item) {
        super.bind(item)

        binding.item = item as UserItem
    }
}
