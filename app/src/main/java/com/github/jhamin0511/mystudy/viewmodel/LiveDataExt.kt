package com.github.jhamin0511.mystudy.viewmodel

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<Event<T>>.event(value: T?) {
    this.value = Event(value)
}
