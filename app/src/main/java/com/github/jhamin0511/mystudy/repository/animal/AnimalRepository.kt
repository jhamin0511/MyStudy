package com.github.jhamin0511.mystudy.repository.animal

import com.github.jhamin0511.mystudy.data.dto.animal.AnimalDto
import com.github.jhamin0511.mystudy.network.service.AnimalService
import com.github.jhamin0511.mystudy.ui.paging.PER_PAGE
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnimalRepository
@Inject constructor(
    private val service: AnimalService
) {

    suspend fun getAnimals(page: Int, search: String): List<AnimalDto> {
        return service.getAnimals(page, PER_PAGE, search).animals
    }
}
