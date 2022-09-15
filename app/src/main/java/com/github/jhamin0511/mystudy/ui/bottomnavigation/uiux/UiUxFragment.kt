package com.github.jhamin0511.mystudy.ui.bottomnavigation.uiux

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentUiuxBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UiUxFragment : BaseFragment(R.layout.fragment_uiux) {
    private lateinit var binding: FragmentUiuxBinding
    private val viewModel: UiUxViewModel by viewModels()

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
