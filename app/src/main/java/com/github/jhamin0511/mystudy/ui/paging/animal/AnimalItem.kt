package com.github.jhamin0511.mystudy.ui.paging.animal

import com.github.jhamin0511.app.common.recycler.Item
import com.github.jhamin0511.mystudy.data.dto.animal.AnimalDto
import com.github.jhamin0511.mystudy.data.dto.animal.AnimalTaste

data class AnimalItem(
    val id: Long,
    val emoji: String,
    val designation: String,
    val lifespan: String,
    val taste: AnimalTaste,
    val summary: String,
    var bookmark: Boolean
) : Item {
    override fun id(): Long {
        return id
    }

    companion object {
        private const val NAME_FORMAT = "%s(%s)"

        fun create(value: AnimalDto): AnimalItem {
            return AnimalItem(
                value.id,
                value.emoji,
                NAME_FORMAT.format(value.designationKo, value.designationEn),
                value.lifespan,
                value.taste,
                value.summary,
                value.bookmark
            )
        }

        fun create(values: List<AnimalDto>): List<AnimalItem> {
            return values.map { create(it) }
        }
    }
}
