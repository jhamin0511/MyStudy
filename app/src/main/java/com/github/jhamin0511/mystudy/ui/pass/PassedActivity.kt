package com.github.jhamin0511.mystudy.ui.pass

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.databinding.CommonPassedBinding
import com.github.jhamin0511.mystudy.key.DTO
import com.github.jhamin0511.mystudy.ui.common.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PassedActivity : BaseActivity() {
    companion object {
        fun start(context: Context, whiskey: WhiskeyDto): Intent {
            return Intent(context, PassedActivity::class.java).apply {
                putExtra(DTO, whiskey)
            }
        }
    }

    private lateinit var binding: CommonPassedBinding
    private val viewModel: PassedViewModel by viewModels()

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.common_passed)
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }
}
