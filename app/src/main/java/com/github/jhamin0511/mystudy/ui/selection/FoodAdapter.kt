package com.github.jhamin0511.mystudy.ui.selection

import android.view.LayoutInflater
import android.view.ViewGroup
import com.github.jhamin0511.mystudy.databinding.ItemFoodBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseAdapter
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder

class FoodAdapter : BaseAdapter() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFoodBinding.inflate(inflater, parent, false)

        return FoodHolder(binding)
    }
}
