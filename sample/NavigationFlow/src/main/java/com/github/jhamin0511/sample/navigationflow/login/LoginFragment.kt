package com.github.jhamin0511.sample.navigationflow.login

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentLoginBinding
import com.github.jhamin0511.sample.navigationflow.logBackstack

class LoginFragment : BaseFragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding
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
            navController.setGraph(R.navigation.nav_graph)
        }
        binding.btSignup.setOnClickListener {
            navController.navigate(R.id.action_loginFragment_to_signupFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController.logBackstack()
    }
}