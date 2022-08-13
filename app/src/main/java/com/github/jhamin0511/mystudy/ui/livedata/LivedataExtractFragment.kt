package com.github.jhamin0511.mystudy.ui.livedata

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.FragmentLivedataExtractBinding
import com.github.jhamin0511.mystudy.ui.common.BaseFragment
import com.github.jhamin0511.mystudy.viewmodel.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LivedataExtractFragment : BaseFragment() {
    private lateinit var binding: FragmentLivedataExtractBinding
    private val viewModel: LivedataExtractViewModel by viewModels()

    override fun getLayoutId() = R.layout.fragment_livedata_extract

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.vm = viewModel

        setHasOptionsMenu(true)
    }

    override fun initObserve() {
        viewModel.observeSave.observe(
            this,
            EventObserver {
                AlertDialog.Builder(requireContext())
                    .setMessage(it.toString())
                    .setPositiveButton(android.R.string.ok) { _, _ -> }
                    .show()
            }
        )
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.save, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save -> {
                viewModel.save()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
