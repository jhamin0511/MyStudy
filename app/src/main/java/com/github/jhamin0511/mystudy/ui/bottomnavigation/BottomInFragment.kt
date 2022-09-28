package com.github.jhamin0511.mystudy.ui.bottomnavigation

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentBottomInBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomInFragment : BaseFragment(R.layout.fragment_bottom_in) {
    private lateinit var binding: FragmentBottomInBinding

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        val hostFragment = childFragmentManager.findFragmentById(R.id.container) as NavHostFragment
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
