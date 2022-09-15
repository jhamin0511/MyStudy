package com.github.jhamin0511.mystudy.ui.bottomnavigation

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentBottomNavigationBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BottomNavigationFragment : BaseFragment(R.layout.fragment_bottom_navigation) {
    private lateinit var binding: FragmentBottomNavigationBinding

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        // no-op comment in an unused listener function
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        binding.btActivity.setOnClickListener {
            val intent = BottomInActivity.start(requireContext())
            startActivity(intent)
        }
        binding.btFragment.setOnClickListener {
            findNavController().navigate(R.id.action_bottomNavigationFragment_to_bottomInFragment)
        }
    }
}
