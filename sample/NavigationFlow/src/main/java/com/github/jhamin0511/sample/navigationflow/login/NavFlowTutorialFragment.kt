package com.github.jhamin0511.sample.navigationflow.login

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentFlowTutorialBinding

class NavFlowTutorialFragment : BaseFragment(R.layout.fragment_flow_tutorial) {
    private lateinit var binding: FragmentFlowTutorialBinding

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
