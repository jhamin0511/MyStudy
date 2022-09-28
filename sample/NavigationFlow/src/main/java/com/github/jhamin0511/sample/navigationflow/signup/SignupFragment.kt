package com.github.jhamin0511.sample.navigationflow.signup

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.application.isLogin
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentSignupBinding

class SignupFragment : BaseFragment(R.layout.fragment_signup) {
    private lateinit var binding: FragmentSignupBinding
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
            isLogin = true
            navController.setGraph(R.navigation.nav_graph)
        }
    }
}
