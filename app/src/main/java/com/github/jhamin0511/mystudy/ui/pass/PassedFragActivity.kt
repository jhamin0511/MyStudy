package com.github.jhamin0511.mystudy.ui.pass

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.databinding.ActivityFragPassedBinding
import com.github.jhamin0511.mystudy.key.DTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PassedFragActivity : com.github.jhamin0511.app.common.BaseActivity() {
    companion object {
        fun start(context: Context, whiskeyDto: WhiskeyDto): Intent {
            return Intent(context, PassedFragActivity::class.java).apply {
                putExtra(DTO, whiskeyDto)
            }
        }
    }

    private lateinit var binding: ActivityFragPassedBinding

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_frag_passed)
        binding.lifecycleOwner = this

        supportFragmentManager.commit {
            intent.getParcelableExtra<WhiskeyDto>(DTO)?.let {
                val fragment = PassedArgsFragment.startArgument(it)
                add(R.id.container, fragment)
            }
        }
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }
}
