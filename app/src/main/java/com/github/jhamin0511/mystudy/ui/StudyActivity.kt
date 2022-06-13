package com.github.jhamin0511.mystudy.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.StudyVo
import com.github.jhamin0511.mystudy.databinding.ActivityStudyBinding
import com.github.jhamin0511.mystudy.widget.AdapterClickListener
import com.github.jhamin0511.mystudy.widget.defaultDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StudyActivity : AppCompatActivity(), AdapterClickListener<StudyVo> {

    private lateinit var binding: ActivityStudyBinding
    private val adapter = StudyAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_study)
        binding.lifecycleOwner = this
        binding.list.adapter = adapter
        binding.list.defaultDecoration(this)

        val items = resources.getTextArray(R.array.study).map {
            StudyVo(it.toString())
        }
        adapter.addAll(items)
    }

    override fun onClickListener(position: Int, item: StudyVo) {
        // no-op comment in an unused listener function
    }
}
