package com.github.jhamin0511.mystudy.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.jhamin0511.mystudy.data.StudyVo
import com.github.jhamin0511.mystudy.widget.AdapterClickListener
import com.github.jhamin0511.mystudy.widget.BaseAdapter

class StudyAdapter(
    private val listener: AdapterClickListener<StudyVo>
) : BaseAdapter<StudyVo>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return StudyHolder.create(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = get(position)

        if (holder is StudyHolder) {
            holder.bind(item)
            holder.setClickListener(item, listener)
        }
    }
}
