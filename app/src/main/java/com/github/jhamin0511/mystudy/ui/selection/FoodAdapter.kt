package com.github.jhamin0511.mystudy.ui.selection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.selection.SelectionTracker
import com.github.jhamin0511.mystudy.databinding.ItemFoodBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseAdapter
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder

class FoodAdapter(
    private val itemClick: FoodItemClickListener
) : BaseAdapter() {

    init {
        setHasStableIds(true)
    }

    var tracker: SelectionTracker<Long>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemFoodBinding.inflate(inflater, parent, false)

        return FoodHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: BaseHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        tracker?.let {
            val id = (getItem(position) as FoodItem).id
            val selected = it.isSelected(id)
            (holder as FoodHolder).select(selected)
        }
    }

    override fun getItemId(position: Int): Long {
        val foodItem = getItem(position) as FoodItem

        return foodItem.id
    }
}
