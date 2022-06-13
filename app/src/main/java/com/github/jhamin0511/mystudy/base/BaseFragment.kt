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
    abstract fun bindValue()
    abstract fun bindView(view: View)
    abstract fun bindObserve()
    abstract fun bindEvent()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindView(view)
        bindValue()
        bindObserve()
        bindEvent()
    }
}
