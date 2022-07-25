package com.github.jhamin0511.mystudy.ui.diffutil

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.databinding.FragmentDiffutilBinding
import com.github.jhamin0511.mystudy.key.DTO
import com.github.jhamin0511.mystudy.key.REQUEST
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiffutilFragment : BaseFragment() {
    private lateinit var binding: FragmentDiffutilBinding
    private val viewModel: DiffutilViewModel by viewModels()
    private val itemClick by lazy { WhiskeyItemClick(findNavController()) }
    private val holderClick by lazy {
        WhiskeyHolderClick(findNavController(), viewModel.dataSource)
    }
    private val holderLongClick by lazy {
        WhiskeyHolderLongClick(viewModel.dataSource)
    }
    private val adapter by lazy { WhiskeyAdapter(holderClick, holderLongClick, itemClick) }

    override fun getLayoutId(): Int {
        return R.layout.fragment_diffutil
    }

    override fun initValue() {
        viewModel.callWhiskeys()
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.defaultDecoration(requireContext())
        binding.recycler.adapter = adapter
    }

    override fun initObserve() {
        viewModel.observeItems.observe(
            this,
            EventObserver {
                adapter.submitList(it)
            }
        )
    }

    override fun initEvent() {
        setFragmentResultListener(REQUEST) { _, bundle ->
            val dto = bundle.get(DTO) as WhiskeyDto
            viewModel.dataSource.update(dto)
        }
    }
}
