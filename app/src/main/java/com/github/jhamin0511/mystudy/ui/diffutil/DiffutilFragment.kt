package com.github.jhamin0511.mystudy.ui.diffutil

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentDiffutilBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiffutilFragment : BaseFragment() {
    private lateinit var binding: FragmentDiffutilBinding
    private val viewModel: DiffutilViewModel by viewModels()
    private val adapter = WhiskeyAdapter()

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
        // no-op comment in an unused listener function
    }
}
