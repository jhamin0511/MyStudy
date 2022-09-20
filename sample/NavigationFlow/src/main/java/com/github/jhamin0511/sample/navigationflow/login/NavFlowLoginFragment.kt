package com.github.jhamin0511.sample.navigationflow.login

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentFlowLoginBinding

class NavFlowLoginFragment : BaseFragment(R.layout.fragment_flow_login) {
    private lateinit var binding: FragmentFlowLoginBinding
    private val navController by lazy { findNavController() }

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
            navController.navigate(R.id.action_navFlowLoginFragment_to_navFlowMainFragment)
        }
        binding.btSignup.setOnClickListener {
            navController.navigate(R.id.action_navFlowLoginFragment_to_navFlowSignupFragment)
        }
    }
}
