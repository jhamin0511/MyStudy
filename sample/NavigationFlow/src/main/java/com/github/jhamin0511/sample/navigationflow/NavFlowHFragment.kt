package com.github.jhamin0511.sample.navigationflow

import android.view.View
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentFlowHBinding

class NavFlowHFragment : BaseFragment(R.layout.fragment_flow_h) {
    private lateinit var binding: FragmentFlowHBinding

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
//        val options = NavOptions.Builder()
//            .setPopUpTo(R.id.navFlowCFragment, inclusive = true, saveState = false)
//            .build()
//        binding.btDeeplinkD.setOnClickListener {
//            navController.navigate(Uri.parse("mystudy://dash/d"), options)
//        }
//        binding.btDeeplinkE.setOnClickListener {
//            navController.navigate(Uri.parse("mystudy://dash/e"), options)
//        }
//        binding.btDeeplinkF.setOnClickListener {
//            navController.navigate(Uri.parse("mystudy://dash/f"), options)
//        }
//        binding.btDeeplinkG.setOnClickListener {
//            navController.navigate(Uri.parse("mystudy://dash/g"), options)
//        }
//        binding.btNavigateD.setOnClickListener {
//            navController.navigate(R.id.action_global_navFlowDDashFragment)
//        }
//        binding.btNavigateE.setOnClickListener {
//
//        }
//        binding.btNavigateF.setOnClickListener {
//
//        }
//        binding.btNavigateG.setOnClickListener {
//
//        }
    }
}
