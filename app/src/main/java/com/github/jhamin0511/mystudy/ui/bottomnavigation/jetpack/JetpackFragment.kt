package com.github.jhamin0511.mystudy.ui.bottomnavigation.jetpack

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.app.common.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentJetpackBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JetpackFragment : BaseFragment(R.layout.fragment_jetpack) {
    private lateinit var binding: FragmentJetpackBinding
    private val viewModel: JetpackViewModel by viewModels()

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
