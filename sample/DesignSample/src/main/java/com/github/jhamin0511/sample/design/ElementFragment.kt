package com.github.jhamin0511.sample.design

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.recycler.HolderItemClickListener
import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.app.common.recycler.defaultDecoration
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.design.databinding.FragmentElementBinding

class ElementFragment : BaseFragment(R.layout.fragment_element) {
    private lateinit var binding: FragmentElementBinding
    private val navController: NavController by lazy { findNavController() }
    private val itemClick = object : HolderItemClickListener {
        override fun onClick(item: Item, position: Int) {
            val element = item as ElementItem
            navController.navigate(element.navigation)
        }
    }
    private val adapter = ElementAdapter(itemClick)

    override fun initValue() {
        adapter.addItems(ElementCreator.create())
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.recycler.defaultDecoration(requireContext())
        binding.recycler.adapter = adapter
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
