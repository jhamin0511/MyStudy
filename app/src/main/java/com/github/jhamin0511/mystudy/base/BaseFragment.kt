package com.github.jhamin0511.mystudy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {
    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun initValue()
    abstract fun initView(view: View)
    abstract fun initObserve()
    abstract fun initEvent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initValue()
        initView(view)
        initObserve()
        initEvent()
    }
}
