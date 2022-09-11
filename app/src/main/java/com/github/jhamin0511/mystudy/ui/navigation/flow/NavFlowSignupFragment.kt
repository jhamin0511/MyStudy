package com.github.jhamin0511.mystudy.ui.navigation.flow

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentFlowSignupBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavFlowSignupFragment : BaseFragment() {
    private lateinit var binding: FragmentFlowSignupBinding
    private val navController by lazy { findNavController() }

    override fun getLayoutId() = R.layout.fragment_flow_signup

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
        binding.btMain.setOnClickListener {
            navController.navigate(R.id.action_navFlowSignupFragment_to_navFlowMainFragment)
        }
    }
}
