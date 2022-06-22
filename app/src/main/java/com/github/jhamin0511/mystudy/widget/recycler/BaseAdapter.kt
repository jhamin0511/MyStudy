package com.github.jhamin0511.mystudy.widget.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter<VH : BaseHolder>(
    private val listener: ItemClickListener? = null
) : RecyclerView.Adapter<VH>() {
    val query: AdapterQuery = AdapterQueryImpl(this)

    fun getItem(position: Int): BaseItem<VH> {
        @Suppress("UNCHECKED_CAST")
        return query.getItem(position).get() as BaseItem<VH>
    }

    override fun getItemCount(): Int {
        return query.size()
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).getViewType()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val item = getItemForViewType(viewType)
        val view = inflater.inflate(item.getItemLayout(), parent, false)

        return item.createViewHolder(view)
    }

    private fun getItemForViewType(viewType: Int): BaseItem<VH> {
        query.getItems().forEachIndexed { _, adapterItem ->
            val item = adapterItem.get()
            if (item.getViewType() == viewType) {
                @Suppress("UNCHECKED_CAST")
                return item as BaseItem<VH>
            }
        }

        error("Could not find view type: $viewType")
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        getItem(position).bind(holder, position, null, listener)
    }

    override fun onBindViewHolder(holder: VH, position: Int, payloads: MutableList<Any>) {
        getItem(position).bind(holder, position, payloads, listener)
    }
}
