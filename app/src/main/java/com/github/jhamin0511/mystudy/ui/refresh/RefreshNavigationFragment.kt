package com.github.jhamin0511.mystudy.ui.refresh

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentRefreshNavigationBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RefreshNavigationFragment : BaseFragment() {
    private lateinit var binding: FragmentRefreshNavigationBinding

    override fun getLayoutId() = R.layout.fragment_refresh_navigation

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        val hostFragment =
            childFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = hostFragment.findNavController()
        binding.bottomNavigation.setupWithNavController(navController)
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
