package com.github.jhamin0511.app.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import timber.log.Timber

@Suppress("TooManyFunctions")
abstract class BaseFragment(
    @LayoutRes private val layoutId: Int
) : Fragment(layoutId) {
    abstract fun initValue()
    abstract fun initView(view: View)
    abstract fun initObserve()
    abstract fun initEvent()

    private val tagName = "Lifecycle_${this::class.simpleName}"

    override fun onAttach(context: Context) {
        super.onAttach(context)

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onAttach()")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onCreate()")
        }

        initValue()
        initObserve()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onCreateView()")
        }

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onViewCreated()")
        }

        initView(view)
        initEvent()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onViewStateRestored()")
        }
    }

    override fun onStart() {
        super.onStart()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onStart()")
        }
    }

    override fun onResume() {
        super.onResume()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onResume()")
        }
    }

    override fun onPause() {
        super.onPause()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onPause()")
        }
    }

    override fun onStop() {
        super.onStop()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onStop()")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onSaveInstanceState()")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onDestroyView()")
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onDestroy()")
        }
    }

    override fun onDetach() {
        super.onDetach()

        if (LIFECYCLE_FLOW_LOG_ENABLE) {
            Timber.tag(tagName).i("onDetach()")
        }
    }
}
