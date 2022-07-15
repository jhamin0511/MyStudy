package com.github.jhamin0511.mystudy.ui.paging.user

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentUserBinding
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick
import com.github.jhamin0511.mystudy.widget.recycler.ItemLongClick
import com.github.jhamin0511.mystudy.widget.setVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class UserFragment : BaseFragment() {
    private lateinit var binding: FragmentUserBinding
    private val viewModel: UserViewModel by viewModels()
    private val userClick = object : ItemClick {
        override fun onClick(item: Item, position: Int) {
            startUserDetail(item)
        }
    }
    private val userLongClick = object : ItemLongClick {
        override fun onLongClick(item: Item, position: Int) {
            // no-op comment in an unused listener function
        }
    }
    private val adapter = UserAdapter(userClick, userLongClick)

    override fun getLayoutId() = R.layout.fragment_user

    override fun bindValue() {
        // no-op comment in an unused listener function
    }

    override fun bindView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.adapter = adapter

        setHasOptionsMenu(true)
    }

    override fun bindObserve() {
        viewModel.observeItems.observe(this) { observe ->
            Timber.i("observeItems.observe() : $observe")
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
        binding.fabRefresh.setOnClickListener {
            adapter.refresh()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.paging_type, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_network -> {
                viewModel.setType(UserPagingType.NETWORK)
                true
            }
            R.id.menu_database -> {
                viewModel.setType(UserPagingType.DATABASE)
                true
            }
            R.id.menu_net_db -> {
                viewModel.setType(UserPagingType.NET_DB)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun startUserDetail(item: Item) {
        when (viewModel.getType()) {
            UserPagingType.DATABASE, UserPagingType.NET_DB -> {
                val id = (item as UserItem).id
                val action = UserFragmentDirections.actionUserFragmentToUserDetailFragment(id)
                findNavController().navigate(action)
            }
            else -> {
                Toast.makeText(
                    requireContext(),
                    R.string.detail_not_support,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
