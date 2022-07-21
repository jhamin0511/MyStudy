package com.github.jhamin0511.mystudy.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.inputmethod.EditorInfo
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.widget.addTextChangedListener
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.github.jhamin0511.mystudy.databinding.ViewSearchBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

private const val KEYWORD_CHANGED_DELAY = 1000L

class SearchView
@JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: ViewSearchBinding
    private var listener: InverseBindingListener? = null
    private var onChanged: ((String) -> Unit)? = null

    init {
        binding = ViewSearchBinding.inflate(LayoutInflater.from(context), this, true)
        binding.etKeyword.addTextChangedListener {
            binding.ivCancel.setVisibleGone(it)
        }
        binding.etKeyword.addTextChangedListener {
            listener?.onChange()
        }
        var job: Job? = null
        binding.etKeyword.addTextChangedListener {
            job?.cancel()
            job = CoroutineScope(Dispatchers.Main).launch {
                delay(KEYWORD_CHANGED_DELAY)
                onChanged?.invoke(it.toString())
                job = null
            }
        }
        binding.ivCancel.setOnClickListener {
            binding.etKeyword.text = null
        }
    }

    fun setKeyword(value: String?) {
        binding.etKeyword.setText(value)
    }

    fun getKeyword(): String {
        return binding.etKeyword.text.toString()
    }

    fun setKeywordInverse(listener: InverseBindingListener) {
        this.listener = listener
    }

    fun setKeywordChanged(onChanged: (String) -> Unit) {
        this.onChanged = onChanged
    }

    fun setKeywordEditorAction(event: () -> Unit) {
        binding.etKeyword.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                event()
                true
            } else {
                false
            }
        }
    }
}

object SearchViewAdapter {
    @JvmStatic
    @BindingAdapter("bindKeyword")
    fun setBindKeyword(view: SearchView, value: String?) {
        val old = view.getKeyword()

        if (old != value) {
            view.setKeyword(value)
        }
    }

    @JvmStatic
    @BindingAdapter("bindOnChangeKeyword")
    fun bindOnChangeKeyword(view: SearchView, listener: InverseBindingListener) {
        view.setKeywordInverse(listener)
    }

    @JvmStatic
    @InverseBindingAdapter(attribute = "bindKeyword", event = "bindOnChangeKeyword")
    fun getBindKeyword(view: SearchView): String {
        return view.getKeyword()
    }
}
