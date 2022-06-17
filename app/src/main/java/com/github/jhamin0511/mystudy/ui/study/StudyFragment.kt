package com.github.jhamin0511.mystudy.ui.study

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentStudyBinding
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.recycler.AdapterClickListener
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyFragment : BaseFragment<FragmentStudyBinding>(), AdapterClickListener<String> {

    private val viewModel: StudyViewModel by viewModels()
    private val adapter = StudyAdapter(this)

    override fun getLayoutId() = R.layout.fragment_study

    override fun bindValue() {
        // no-op comment in an unused listener function
    }

    override fun bindView() {
        binding.list.defaultDecoration(requireContext())
        binding.list.adapter = adapter
    }

    override fun bindObserve() {
        viewModel.observeStudies.observe(
            this,
            EventObserver {
                adapter.addAll(it)
            }
        )
    }

    override fun bindEvent() {
        // no-op comment in an unused listener function
    }

    override fun onClickListener(position: Int, item: String) {
        when (item) {
            getString(R.string.notification) -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.action_studyFragment_to_notificationFragment)
            }
        }
    }
}
