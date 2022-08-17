package com.github.jhamin0511.mystudy.ui.bottomnavigation

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentBottomInBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomInFragment : BaseFragment() {
    private lateinit var binding: FragmentBottomInBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController

    override fun getLayoutId() = R.layout.fragment_bottom_in

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        val hostFragment = childFragmentManager.findFragmentById(R.id.container) as NavHostFragment
        navController = hostFragment.findNavController()
        binding.bottomNavigation.setupWithNavController(navController)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.jetpackFragment,
                R.id.libraryFragment,
                R.id.customFragment,
                R.id.uiUxFragment
            )
        )
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
