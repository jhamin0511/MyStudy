package com.github.jhamin0511.mystudy.ui.study

import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.app.common.BaseActivity
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.databinding.ActivityStudyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyActivity : BaseActivity() {
    private lateinit var binding: ActivityStudyBinding

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_study)
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        // no-op comment in an unused listener function
    }

    override fun onPause() {
        super.onPause()

        overridePendingTransition(0, R.anim.translate_activity_stay)
    }
}
