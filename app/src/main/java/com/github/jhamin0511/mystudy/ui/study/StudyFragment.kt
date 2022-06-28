package com.github.jhamin0511.mystudy.ui.study

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentStudyBinding
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import com.github.jhamin0511.mystudy.widget.recycler2.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyFragment : BaseFragment<FragmentStudyBinding>() {

    private val viewModel: StudyViewModel by viewModels()
    private val studyClickListener = object : ItemClickListener<StudyItem> {
        override fun onClick(item: StudyItem, position: Int) {
            Navigation.findNavController(binding.root).navigate(item.navigateRes)
        }
    }
    private val adapter = StudyAdapter(studyClickListener)

    override fun getLayoutId() = R.layout.fragment_study

    override fun bindValue() {
        // no-op comment in an unused listener function
    }

    override fun bindView() {
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
