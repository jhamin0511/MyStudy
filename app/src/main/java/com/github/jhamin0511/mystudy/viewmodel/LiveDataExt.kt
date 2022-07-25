package com.github.jhamin0511.mystudy.viewmodel

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<Event<T>>.event(value: T?) {
    this.value = Event(value)
}

fun <T> MutableLiveData<T>.get(default: T? = null): T {
    return this.value ?: default ?: throw NullPointerException("this.value is null.")
}
