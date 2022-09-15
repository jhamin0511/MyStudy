package com.github.jhamin0511.mystudy.ui.bindingleack

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentBindingTwoBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class BindingTwoClearFragment : BaseFragment(R.layout.fragment_binding_two) {
    private lateinit var binding: FragmentBindingTwoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.i("BackStackSize : ${findNavController().backQueue.size}")
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
        binding.btStart.setOnClickListener {
            findNavController()
                .navigate(R.id.action_bindingTwoClearFragment_to_bindingOneClearFragment)
        }
    }
}
