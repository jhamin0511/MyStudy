package com.github.jhamin0511.mystudy.ui.paging.user

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.github.jhamin0511.app.common.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentUserBinding
import com.github.jhamin0511.mystudy.time.GlobalTime
import com.github.jhamin0511.mystudy.ui.paging.PagingErrorHandler
import com.github.jhamin0511.mystudy.widget.recycler.HolderItemClickListener
import com.github.jhamin0511.mystudy.widget.recycler.HolderItemLongClickListener
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.setVisible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class UserFragment : BaseFragment(R.layout.fragment_user) {
    private lateinit var binding: FragmentUserBinding
    private val viewModel: UserViewModel by viewModels()
    private val userClick = object : HolderItemClickListener {
        override fun onClick(item: Item, position: Int) {
            startUserDetail(item, position)
        }
    }
    private val userLongClick = object : HolderItemLongClickListener {
        override fun onLongClick(item: Item, position: Int) {
            // no-op comment in an unused listener function
        }
    }
    private val adapter = UserAdapter(userClick, userLongClick)
    private val handler by lazy { PagingErrorHandler(requireContext()) }

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.adapter = adapter

        setHasOptionsMenu(true)
    }

    override fun initObserve() {
        viewModel.observeItems.observe(this) { observe ->
            Timber.i("observeItems.observe() : $observe")
            lifecycleScope.launch {
                observe.collectLatest { pagingData ->
                    adapter.submitData(pagingData)
                }
            }
        }
    }

    override fun initEvent() {
        lifecycleScope.launchWhenCreated {
            adapter.loadStateFlow.collectLatest {
                handler.showToast(it)

                if (binding.refresh.isRefreshing) {
                    binding.refresh.isRefreshing = it.refresh is LoadState.Loading
                } else {
                    binding.progress.isVisible = it.refresh is LoadState.Loading ||
                        it.append is LoadState.Loading
                    it.source.refresh
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

    private fun startUserDetail(item: Item, position: Int) {
        when (viewModel.getType()) {
            UserPagingType.DATABASE, UserPagingType.NET_DB -> {
                val id = (item as UserItem).id
                val action = UserFragmentDirections.actionUserFragmentToUserDetailFragment(id)
                findNavController().navigate(action)
            }
            else -> {
                val items = adapter.snapshot().items
                val convertDate = GlobalTime.convertDate(System.currentTimeMillis())
                (items[position] as UserItem).name = convertDate
                (items[position] as UserItem).date = convertDate
                adapter.notifyDataSetChanged()
            }
        }
    }
}
