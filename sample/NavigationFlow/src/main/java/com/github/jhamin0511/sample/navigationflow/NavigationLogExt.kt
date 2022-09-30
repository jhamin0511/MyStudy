package com.github.jhamin0511.sample.navigationflow

import androidx.navigation.NavController
import timber.log.Timber

private const val TAG = "NavController"

fun NavController.logBackstack() {
    Timber.tag(TAG).d("NavController : $this")
    val queue = this.backQueue
    queue.forEach { entry ->
        Timber.tag(TAG).d("entry : $entry")
        Timber.tag(TAG).d("id : ${entry.id}")
        Timber.tag(TAG).d("destination : ${entry.destination}")
    }
}
