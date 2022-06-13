package com.github.jhamin0511.mystudy.ui.study

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.StudyVo
import com.github.jhamin0511.mystudy.databinding.ItemStudyBinding
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder

class StudyHolder(view: View) : BaseHolder<StudyVo>(view) {

    companion object {
        fun create(viewGroup: ViewGroup): StudyHolder {
            val inflater = LayoutInflater.from(viewGroup.context)
            val view = inflater.inflate(R.layout.item_study, viewGroup, false)

            return StudyHolder(view)
        }
    }

    private val binding: ItemStudyBinding = DataBindingUtil.bind(view)!!

    override fun bind(item: StudyVo) {
        binding.vo = item
    }
}
