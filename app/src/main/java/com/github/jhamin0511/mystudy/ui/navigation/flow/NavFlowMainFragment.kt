package com.github.jhamin0511.mystudy.ui.navigation.flow

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentFlowMainBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class NavFlowMainFragment : BaseFragment() {
    private lateinit var binding: FragmentFlowMainBinding
    private val rootNavController by lazy { findNavController() }

    override fun getLayoutId() = R.layout.fragment_flow_main

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        val hostFragment =
            childFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val bottomNavController = hostFragment.findNavController()
        Timber.i("rootNavController : $rootNavController / bottomNavController : $bottomNavController")
        binding.bottomNavigation.setupWithNavController(bottomNavController)

        Timber.i("bottomNavigation VISIBLE : ${binding.bottomNavigation.visibility == View.VISIBLE}")
//        bottomNavController.addOnDestinationChangedListener { _, destination, _ ->
//            Timber.i("destination : $destination")
//            val bottomD = destination.id == R.id.navFlowDFragment
//            val bottomE = destination.id == R.id.navFlowEFragment
//            val bottomF = destination.id == R.id.navFlowFFragment
//            val bottomG = destination.id == R.id.navFlowGFragment
//            Timber.i("bottomD : $bottomD / bottomE : $bottomE / bottomF : $bottomF / bottomG : $bottomG / ")
//            val bottomVisible = bottomD or bottomE or bottomF or bottomG
//
//            binding.bottomNavigation.setVisible(bottomVisible)
//            binding.clSub.setVisible(bottomVisible)
//        }
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        binding.btH.setOnClickListener {
//            rootNavController.navigate(R.id.action_navFlowCFragment_to_navFlowHFragment)
        }
    }
}
