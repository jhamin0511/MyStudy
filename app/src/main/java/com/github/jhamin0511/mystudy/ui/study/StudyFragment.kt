package com.github.jhamin0511.mystudy.ui.study

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.data.StudyVo
import com.github.jhamin0511.mystudy.databinding.FragmentStudyBinding
import com.github.jhamin0511.mystudy.widget.recycler.AdapterClickListener
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration

class StudyFragment : BaseFragment(), AdapterClickListener<StudyVo> {
    private lateinit var binding: FragmentStudyBinding
    private val adapter = StudyAdapter(this)

    override fun getLayoutId() = R.layout.fragment_study

    override fun bindValue() {
        val items = resources.getTextArray(R.array.study).map {
            StudyVo(it.toString())
        }
        adapter.addAll(items)
    }

    override fun bindView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.list.defaultDecoration(requireContext())
        binding.list.adapter = adapter
    }

    override fun bindObserve() {
        // no-op comment in an unused listener function
    }

    override fun bindEvent() {
        // no-op comment in an unused listener function
    }

    override fun onClickListener(position: Int, item: StudyVo) {
        // no-op comment in an unused listener function
    }
}
