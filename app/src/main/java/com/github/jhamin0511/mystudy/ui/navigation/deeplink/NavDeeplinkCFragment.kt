package com.github.jhamin0511.mystudy.ui.navigation.deeplink

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentDeeplinkCBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import com.github.jhamin0511.mystudy.widget.setVisible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NavDeeplinkCFragment : BaseFragment() {
    private lateinit var binding: FragmentDeeplinkCBinding
    private val navController by lazy { findNavController() }

    override fun getLayoutId() = R.layout.fragment_deeplink_c

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        val hostFragment =
            childFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val bottomNavController = hostFragment.findNavController()

        binding.bottomNavigation.setupWithNavController(bottomNavController)
        bottomNavController.addOnDestinationChangedListener { _, destination, _ ->
            val bottomD = destination.id == R.id.navDeeplinkDFragment
            val bottomE = destination.id == R.id.navDeeplinkEFragment
            val bottomF = destination.id == R.id.navDeeplinkFFragment
            val bottomG = destination.id == R.id.navDeeplinkGFragment
            val bottomVisible = bottomD or bottomE or bottomF or bottomG

            binding.bottomNavigation.setVisible(bottomVisible)
            binding.clSub.setVisible(bottomVisible)
        }
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        binding.btH.setOnClickListener {
            navController.navigate(R.id.action_navDeeplinkCFragment_to_navDeeplinkHFragment)
        }
    }
}
