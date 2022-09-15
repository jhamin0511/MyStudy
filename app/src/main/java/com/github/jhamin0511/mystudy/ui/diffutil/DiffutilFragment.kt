package com.github.jhamin0511.mystudy.ui.diffutil

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.databinding.FragmentDiffutilBinding
import com.github.jhamin0511.mystudy.key.DTO
import com.github.jhamin0511.mystudy.key.REQUEST
import com.github.jhamin0511.mystudy.widget.recycler.defaultDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiffutilFragment : BaseFragment(R.layout.fragment_diffutil) {
    private lateinit var binding: FragmentDiffutilBinding
    private val viewModel: DiffutilViewModel by viewModels()
    private val itemClick by lazy { WhiskeyItemClick(findNavController(), viewModel.dataSource) }
    private val holderClick by lazy {
        WhiskeyHolderClick(findNavController(), viewModel.dataSource)
    }
    private val holderLongClick by lazy {
        WhiskeyHolderLongClick(viewModel.dataSource)
    }
    private val adapter by lazy { WhiskeyAdapter(holderClick, holderLongClick, itemClick) }

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel
        binding.recycler.defaultDecoration(requireContext())
        binding.recycler.adapter = adapter

        setHasOptionsMenu(true)
    }

    override fun initObserve() {
        viewModel.observeItems.observe(this) {
            adapter.submitList(it)
        }
    }

    override fun initEvent() {
        setFragmentResultListener(REQUEST) { _, bundle ->
            val dto = bundle.get(DTO) as WhiskeyDto
            viewModel.dataSource.update(dto)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.confirm, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.confirm -> {
                val list = viewModel.dataSource.getSelected()
                Toast.makeText(requireContext(), list.toString(), Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
