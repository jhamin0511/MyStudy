package com.github.jhamin0511.sample.navigationflow.main

import android.net.Uri
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentFlowCDetailBinding

class NavFlowCDetailFragment : BaseFragment(R.layout.fragment_flow_c_detail) {
    private lateinit var binding: FragmentFlowCDetailBinding
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
            navController.navigate(R.id.action_global_navFlowLoginFragment)
        }
        binding.btStartDeeplinkLogin.setOnClickListener {
            val options = NavOptions.Builder()
                .setPopUpTo(R.id.navFlowLoginFragment, inclusive = true, saveState = false)
                .build()
            val uri = Uri.parse("mystudy://login")
            navController.navigate(uri, options)
        }
    }
}
