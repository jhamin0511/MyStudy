package com.github.jhamin0511.mystudy.ui.paging

import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.vo.User
import com.github.jhamin0511.mystudy.databinding.ItemUserBinding
import com.github.jhamin0511.mystudy.widget.recycler.Item

class UserItem(
    val vo: User
) : Item<ItemUserBinding>() {
    val id = vo.id

    override fun getItemLayout() = R.layout.item_user

    override fun bind(binding: ItemUserBinding, position: Int) {
        binding.vo = vo
    }
}
