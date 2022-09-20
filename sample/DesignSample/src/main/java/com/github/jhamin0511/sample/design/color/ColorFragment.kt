package com.github.jhamin0511.sample.design.color

import android.view.View
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.sample.design.R
import com.github.jhamin0511.sample.design.databinding.FragmentColorBinding

class ColorFragment : BaseFragment(R.layout.fragment_color) {
    companion object {
        private const val DESIGN_PACKAGE = "com.github.jhamin0511.ui.design.R\$color"
        private const val HEX_FORMAT = "#%06X"
        private const val HEXADECIMAL = 0xFFFFFF
    }

    private lateinit var binding: FragmentColorBinding
    private val adapter = ColorAdapter()

    override fun initValue() {
        val fields = Class.forName(DESIGN_PACKAGE).declaredFields
        val items = fields.map {
            val colorId = it.getInt(null)
            val colorRes = ResourcesCompat.getColor(resources, colorId, null)
            val colorHex = HEX_FORMAT.format(HEXADECIMAL and colorRes)
            ColorItem(colorId.toLong(), it.name, colorRes, colorHex)
        }.sortedBy {
            it.colorHex
        }
        adapter.addItems(items)
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.recycler.adapter = adapter
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }
}
