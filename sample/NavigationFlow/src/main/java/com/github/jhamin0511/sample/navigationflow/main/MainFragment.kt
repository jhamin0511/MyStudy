package com.github.jhamin0511.sample.navigationflow.main

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.application.isShowSplash
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentMainBinding
import com.github.jhamin0511.sample.navigationflow.logBackstack

class MainFragment : BaseFragment(R.layout.fragment_main) {
    private lateinit var binding: FragmentMainBinding
    private val navController by lazy { findNavController() }

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
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        binding.btLiqueur.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_liqueurFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController.logBackstack()
        if (!isShowSplash) {
            navController.navigate(R.id.action_mainFragment_to_splashFragment)
            isShowSplash = true
        }
    }
}
