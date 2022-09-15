package com.github.jhamin0511.mystudy.ui.navigation.flow

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.github.jhamin0511.app.common.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentFlowABinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavFlowAFragment : BaseFragment(R.layout.fragment_flow_a) {
    private lateinit var binding: FragmentFlowABinding
    private val navMainController by lazy {
        Navigation.findNavController(requireActivity(), R.id.root_fragment_container)
    }

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
        binding.btDetail.setOnClickListener {
            navMainController.navigate(R.id.action_global_NavFlowADetailFragment)
        }
    }
}
