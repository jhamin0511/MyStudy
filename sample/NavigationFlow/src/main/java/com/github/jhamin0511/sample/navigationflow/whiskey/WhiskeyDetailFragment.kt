package com.github.jhamin0511.sample.navigationflow.whiskey

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.application.isLogin
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentWhiskeyDetailBinding
import com.github.jhamin0511.sample.navigationflow.logBackstack

class WhiskeyDetailFragment : BaseFragment(R.layout.fragment_whiskey_detail) {
    private lateinit var binding: FragmentWhiskeyDetailBinding
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
        binding.btStartActionLogin.setOnClickListener {
            isLogin = false
            navController.setGraph(R.navigation.nav_session)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController.logBackstack()
    }
}
