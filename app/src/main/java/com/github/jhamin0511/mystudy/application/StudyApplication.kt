package com.github.jhamin0511.mystudy.application

import android.app.Application
import androidx.lifecycle.ProcessLifecycleOwner
import com.github.jhamin0511.mystudy.BuildConfig
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

const val SHOW_LIFECYCLE_LOGO = true

@HiltAndroidApp
class StudyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserve())

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}
