package com.github.jhamin0511.mystudy.ui.navigation.flow

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentFlowDBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavFlowDFragment : BaseFragment(R.layout.fragment_flow_d) {
    private lateinit var binding: FragmentFlowDBinding
    private val navMainController by lazy {
        Navigation.findNavController(requireActivity(), R.id.nav_flow)
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
//            navController.navigate(R.id.navFlowGDashFragment)
            navMainController.navigate(R.id.action_global_navFlowDDetailFragment)
        }
    }
}
