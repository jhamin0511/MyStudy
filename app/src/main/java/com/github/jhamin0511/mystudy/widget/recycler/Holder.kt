package com.github.jhamin0511.mystudy.widget.recycler

import androidx.databinding.ViewDataBinding

class Holder<B : ViewDataBinding>(
    val binding: B
) : BaseHolder(binding.root)
