package com.github.jhamin0511.mystudy.application

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleOwner
import timber.log.Timber

class ApplicationLifecycleObserve : LifecycleEventObserver {
    companion object {
        private const val TAG = "Lifecycle_Application"
    }

    override fun onStateChanged(source: LifecycleOwner, event: Lifecycle.Event) {
        if (SHOW_LIFECYCLE_LOGO) {
            Timber.tag(TAG).i("$event()")
        }
    }
}
