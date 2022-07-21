package com.github.jhamin0511.mystudy.ui.paging.github

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.github.GithubRepoDto

class GithubRepoAdapter : PagingDataAdapter<GithubRepoDto, GithubRepoHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GithubRepoDto>() {
            override fun areItemsTheSame(
                oldItem: GithubRepoDto,
                newItem: GithubRepoDto
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: GithubRepoDto,
                newItem: GithubRepoDto
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GithubRepoHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_github_repo, parent, false)

        return GithubRepoHolder(view)
    }

    override fun onBindViewHolder(holder: GithubRepoHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.bind(item)
        }
    }
}
