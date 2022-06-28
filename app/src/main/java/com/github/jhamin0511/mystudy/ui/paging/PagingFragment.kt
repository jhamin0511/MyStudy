package com.github.jhamin0511.mystudy.ui.paging

import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentPagingBinding
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.github.jhamin0511.mystudy.widget.recycler.ItemClick
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PagingFragment : BaseFragment<FragmentPagingBinding>() {

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

    override fun bindView() {
        binding.lifecycleOwner = this
        binding.recycler.adapter = adapter
    }

    override fun bindObserve() {
        viewModel.observeUser.observe(
            this,
            EventObserver {
                Timber.i("items Size : ${it.size}")
                adapter.addItems(it)
            }
        )
    }

    override fun bindEvent() {
        binding.fabAdd.setOnClickListener {
            viewModel.bindClickFab()
        }
    }
}
