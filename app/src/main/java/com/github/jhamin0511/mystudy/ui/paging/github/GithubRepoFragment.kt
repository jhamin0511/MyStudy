package com.github.jhamin0511.mystudy.ui.paging.github

import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentGithubRepoBinding
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class GithubRepoFragment : BaseFragment<FragmentGithubRepoBinding>() {

    private val viewModel: GithubRepoViewModel by viewModels()
    private val adapter = GithubRepoAdapter()

    override fun getLayoutId() = R.layout.fragment_github_repo

    override fun bindValue() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.items.collectLatest {
                    adapter.submitData(it)
                }
            }
        }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                adapter.loadStateFlow.collect {
                    binding.progress.isVisible = it.source.append is LoadState.Loading ||
                            it.source.prepend is LoadState.Loading
                }
            }
        }
    }

    override fun bindView() {
        binding.lifecycleOwner = this
        binding.recycler.defaultDecoration(requireContext())
        binding.recycler.adapter = adapter
    }

    override fun bindObserve() {
        // no-op comment in an unused listener function
    }

    override fun bindEvent() {
        // no-op comment in an unused listener function
    }
}
