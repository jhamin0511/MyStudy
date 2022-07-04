package com.github.jhamin0511.mystudy.ui.study

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentStudyBinding
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyFragment : BaseFragment() {
    private lateinit var binding: FragmentStudyBinding
    private val viewModel: StudyViewModel by viewModels()
    private val studyClickListener = object : ItemClick {
        override fun onClick(item: Item, position: Int) {
            val study = item as StudyItem
            Navigation.findNavController(binding.root).navigate(study.navigateRes)
        }
    }
    private val adapter = StudyAdapter(studyClickListener)

    override fun getLayoutId() = R.layout.fragment_study

    override fun bindValue() {
        // no-op comment in an unused listener function
    }

    override fun bindView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.recycler.defaultDecoration(requireContext())
        binding.recycler.adapter = adapter
    }

    override fun bindObserve() {
        viewModel.observeStudies.observe(
            this,
            EventObserver {
                adapter.addItems(it)
            }
        )
    }

    override fun bindEvent() {
        // no-op comment in an unused listener function
    }
}
