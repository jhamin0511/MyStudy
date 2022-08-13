package com.github.jhamin0511.mystudy.network.request

import com.github.jhamin0511.mystudy.data.vo.BookVo
import com.google.gson.annotations.SerializedName

data class BookEditRequest(
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("author")
    val author: String,
    @SerializedName("translator")
    val translator: String,
    @SerializedName("publisher")
    val publisher: String,
    @SerializedName("introduce")
    var introduce: String
) {
    companion object {
        fun create(vo: BookVo): BookEditRequest {
            return BookEditRequest(
                vo.name,
                vo.title,
                vo.author,
                vo.translator,
                vo.publisher,
                vo.introduce
            )
        }
    }
}
