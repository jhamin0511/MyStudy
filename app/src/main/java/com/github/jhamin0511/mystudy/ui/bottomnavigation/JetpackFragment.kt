package com.github.jhamin0511.mystudy.ui.bottomnavigation

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentJetpackBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JetpackFragment : BaseFragment() {
    private lateinit var binding: FragmentJetpackBinding

    override fun getLayoutId() = R.layout.fragment_jetpack

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
