package com.github.jhamin0511.mystudy.ui.paging

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentPagingBinding
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick
import com.github.jhamin0511.mystudy.widget.setVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PagingFragment : BaseFragment() {
    private lateinit var binding: FragmentPagingBinding
    private val viewModel: PagingViewModel by viewModels()
    private val userClickListener = object : ItemClick {
        override fun onClick(item: Item, position: Int) {
            // no-op comment in an unused listener function
        }
    }
    private val adapter = PagingAdapter(userClickListener)

    override fun getLayoutId() = R.layout.fragment_paging

    override fun bindValue() {
        // no-op comment in an unused listener function
    }

    override fun bindView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.adapter = adapter
    }

    override fun bindObserve() {
        viewModel.observerUserPagingSource().observe(this) { observe ->
            lifecycleScope.launch {
                adapter.submitData(observe)
            }
        }
    }

    override fun bindEvent() {
        lifecycleScope.launch {
            adapter.loadStateFlow.collectLatest {
                if (binding.refresh.isRefreshing) {
                    binding.refresh.isRefreshing = it.refresh is LoadState.Loading
                } else {
                    binding.progress.isVisible = it.refresh is LoadState.Loading ||
                            it.prepend is LoadState.Loading ||
                            it.append is LoadState.Loading
                }
                binding.recyclerEmpty.root.setVisible(adapter.itemCount == 0)
            }
        }
        binding.refresh.setOnRefreshListener {
            adapter.refresh()
        }
        binding.fabAdd.setOnClickListener {
        }
    }
}
