package com.github.jhamin0511.mystudy.ui.study

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.github.jhamin0511.app.common.recycler.HolderItemClickListener
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.app.common.recycler.defaultDecoration
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentStudyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyFragment : BaseFragment(R.layout.fragment_study) {
    private lateinit var binding: FragmentStudyBinding
    private val viewModel: StudyViewModel by viewModels()
    private val studyClick = object : HolderItemClickListener {
        override fun onClick(item: Item, position: Int) {
            val study = item as StudyItem
            Navigation.findNavController(binding.root).navigate(study.navigateRes)
        }
    }
    private val adapter = StudyAdapter(studyClick)

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.recycler.defaultDecoration(requireContext())
        binding.recycler.adapter = adapter
    }

    override fun initObserve() {
        viewModel.observeItems.observe(this) {
            adapter.addItems(it)
        }
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
