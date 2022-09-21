package com.github.jhamin0511.sample.navigationflow

import androidx.navigation.NavController
import timber.log.Timber

private const val TAG = "NavController"

fun NavController.logBackstack() {
    Timber.tag(TAG).d("NavController : $this")
    val queue = this.backQueue
    queue.forEach { entry ->
        val message = """

            entry : $entry
            id : ${entry.id}
            destination : ${entry.destination}
            """
        Timber.tag(TAG).d(message)
    }
}
