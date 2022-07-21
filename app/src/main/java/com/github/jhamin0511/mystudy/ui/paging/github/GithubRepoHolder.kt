package com.github.jhamin0511.mystudy.ui.paging.github

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto
import com.github.jhamin0511.mystudy.databinding.ItemGithubRepoBinding

class GithubRepoHolder(
    val view: View
) : RecyclerView.ViewHolder(view) {
    private val binding: ItemGithubRepoBinding = DataBindingUtil.bind(view)!!

    fun bind(item: GithubRepoDto) {
        binding.item = item
    }
}
