package com.github.jhamin0511.sample.navigationflow.makgeolli

import android.net.Uri
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentMakgeolliDetailBinding

class MakgeolliDetailFragment : BaseFragment(R.layout.fragment_makgeolli_detail) {
    private lateinit var binding: FragmentMakgeolliDetailBinding
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
            navController.setGraph(R.navigation.nav_session)
        }
        binding.btStartDeeplinkLogin.setOnClickListener {
            val deepLink = Uri.parse("navigationflow://detail/makgeolli")
            navController.navigate(deepLink, null)
        }
    }
}