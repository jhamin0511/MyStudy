package com.github.jhamin0511.mystudy.ui.paging

import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.base.BaseFragment
import com.github.jhamin0511.mystudy.databinding.FragmentPagingBinding
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.recycler.BaseAdapter
import com.github.jhamin0511.mystudy.widget.recycler.BaseHolder
import com.github.jhamin0511.mystudy.widget.recycler.BaseItem
import com.github.jhamin0511.mystudy.widget.recycler.ItemClickListener
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class PagingFragment : BaseFragment<FragmentPagingBinding>(), ItemClickListener {

    private val viewModel: PagingViewModel by viewModels()
    private val adapter = BaseAdapter<BaseHolder>(this)

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
                adapter.query.addItems(it)
            }
        )
    }

    override fun bindEvent() {
        binding.fabAdd.setOnClickListener {
            viewModel.bindClickFab()
        }
    }

    override fun onClickListener(position: Int, item: BaseItem<*>) {
        // no-op comment in an unused listener function
    }
}
