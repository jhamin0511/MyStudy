package com.github.jhamin0511.mystudy.ui.study

import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentStudyBinding
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.recycler.BaseAdapter
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.BaseItem
import com.github.jhamin0511.mystudy.widget.recycler.ItemClickListener
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyFragment : BaseFragment<FragmentStudyBinding>(), ItemClickListener {

    private val viewModel: StudyViewModel by viewModels()
    private val adapter = BaseAdapter<BaseHolder>(this)

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
                val items = it.map { vo ->
                    StudyItem(vo)
                }
                adapter.query.addItems(items)
            }
        )
    }

    override fun bindEvent() {
        // no-op comment in an unused listener function
    }

    override fun onClickListener(position: Int, item: BaseItem<*>) {
        if (item is StudyItem) {
            Navigation.findNavController(binding.root).navigate(item.vo.navigateRes)
        }
    }
}
