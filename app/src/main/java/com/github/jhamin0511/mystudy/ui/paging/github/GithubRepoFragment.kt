package com.github.jhamin0511.mystudy.ui.paging.github

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentGithubRepoBinding
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import com.github.jhamin0511.mystudy.widget.setVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GithubRepoFragment : BaseFragment() {
    private lateinit var binding: FragmentGithubRepoBinding
    private val viewModel: GithubRepoViewModel by viewModels()
    private val adapter = GithubRepoAdapter()

    override fun getLayoutId() = R.layout.fragment_github_repo

    override fun initValue() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.items.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                adapter.loadStateFlow.collectLatest {
                    binding.progress.isVisible = it.refresh is LoadState.Loading ||
                            it.prepend is LoadState.Loading ||
                            it.append is LoadState.Loading
                    binding.recyclerEmpty.root.setVisible(adapter.itemCount == 0)
                }
            }
        }
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.defaultDecoration(requireContext())
        binding.recycler.adapter = adapter
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        binding.search.setKeywordChanged {
            adapter.refresh()
        }
        binding.search.setKeywordEditorAction {
            adapter.refresh()
        }
    }
}
