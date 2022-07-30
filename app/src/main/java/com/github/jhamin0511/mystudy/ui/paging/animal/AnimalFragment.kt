package com.github.jhamin0511.mystudy.ui.paging.animal

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentAnimalBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimalFragment : BaseFragment() {
    private lateinit var binding: FragmentAnimalBinding
    private val viewModel: AnimalViewModel by viewModels()
    private val adapter = AnimalAdapter()
    override fun getLayoutId(): Int {
        return R.layout.fragment_animal
    }

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.adapter = adapter

        setHasOptionsMenu(true)
    }

    override fun initObserve() {
        viewModel.observeItems.observe(this) {
            adapter.submitList(it)
        }
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
