package com.github.jhamin0511.mystudy.ui.common

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.github.jhamin0511.mystudy.application.SHOW_LIFECYCLE_LOGO
import timber.log.Timber

@Suppress("TooManyFunctions")
abstract class BaseFragment : Fragment() {
    @LayoutRes
    abstract fun getLayoutId(): Int
    abstract fun initValue()
    abstract fun initView(view: View)
    abstract fun initObserve()
    abstract fun initEvent()

    private val tagName = "Lifecycle_${this::class.simpleName}"

    override fun onAttach(context: Context) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onAttach()")
        }
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onCreate()")
        }
        super.onCreate(savedInstanceState)

        initValue()
        initObserve()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onCreateView()")
        }
        return inflater.inflate(getLayoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onViewCreated()")
        }
        initView(view)
        initEvent()
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onViewStateRestored()")
        }
        super.onViewStateRestored(savedInstanceState)
    }

    override fun onStart() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onStart()")
        }
        super.onStart()
    }

    override fun onResume() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onResume()")
        }
        super.onResume()
    }

    override fun onPause() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onPause()")
        }
        super.onPause()
    }

    override fun onStop() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onStop()")
        }
        super.onStop()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onSaveInstanceState()")
        }
        super.onSaveInstanceState(outState)
    }

    override fun onDestroyView() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onDestroyView()")
        }
        super.onDestroyView()
    }

    override fun onDestroy() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onDestroy()")
        }
        super.onDestroy()
    }

    override fun onDetach() {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(tagName).i("onDetach()")
        }
        super.onDetach()
    }
}
