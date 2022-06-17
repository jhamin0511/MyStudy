package com.github.jhamin0511.mystudy.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<BINDING : ViewDataBinding> : Fragment() {
    protected lateinit var binding: BINDING

    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun bindValue()
    abstract fun bindView()
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
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this

        bindValue()
        bindView()
        bindObserve()
        bindEvent()
    }
}
