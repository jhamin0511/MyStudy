package com.github.jhamin0511.sample.navigationflow.main

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.navigationflow.R
import com.github.jhamin0511.sample.navigationflow.databinding.FragmentWhiskeyBinding
import com.github.jhamin0511.sample.navigationflow.logBackstack

class WhiskeyFragment : BaseFragment(R.layout.fragment_whiskey) {
    private lateinit var binding: FragmentWhiskeyBinding
    private val navController by lazy {
        Navigation.findNavController(requireActivity(), R.id.fragment_container)
    }

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
        binding.btDetail.setOnClickListener {
            navController.navigate(R.id.action_global_whiskeyDetailFragment)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        navController.logBackstack()
    }
}
