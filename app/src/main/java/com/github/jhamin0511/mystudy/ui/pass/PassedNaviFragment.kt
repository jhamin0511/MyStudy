package com.github.jhamin0511.mystudy.ui.pass

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.CommonPassedBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PassedNaviFragment : BaseFragment() {
    private lateinit var binding: CommonPassedBinding
    private val viewModel: PassedViewModel by viewModels()

    override fun getLayoutId() = R.layout.common_passed

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
