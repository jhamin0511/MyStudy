package com.github.jhamin0511.mystudy.test

import androidx.recyclerview.widget.ListUpdateCallback

class UpdateCallBack : ListUpdateCallback {
    override fun onInserted(position: Int, count: Int) {
        // no-op comment in an unused listener function
    }

    override fun onRemoved(position: Int, count: Int) {
        // no-op comment in an unused listener function
    }

    override fun onMoved(fromPosition: Int, toPosition: Int) {
        // no-op comment in an unused listener function
    }

    override fun onChanged(position: Int, count: Int, payload: Any?) {
        // no-op comment in an unused listener function
    }
}
