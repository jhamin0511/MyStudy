package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.data.dto.animal.AnimalDto
import com.github.jhamin0511.mystudy.network.response.AnimalsResponse

private const val END_PAGE = 1000
private const val DIV_SIZE = 22

@Suppress("MagicNumber", "ComplexMethod")
class AnimalServiceImpl : AnimalService {
    private var id: Long = 1
    private var preCount: Int = 1
    private var preSearch = ""

    override suspend fun getAnimals(page: Int, perPage: Int, search: String): AnimalsResponse {
        if (preSearch != search) {
            id = 1
            preCount = 1
            preSearch = search
        }

        val list = mutableListOf<AnimalDto>()
        val loadCount = preCount.plus(perPage)
        val last = page == END_PAGE

        for (i: Int in preCount until loadCount) {
            val dto = when (i % DIV_SIZE) {
                1 -> AnimalDto.monkey(id)
                2 -> AnimalDto.orangutan(id)
                3 -> AnimalDto.dog(id)
                4 -> AnimalDto.wolf(id)
                5 -> AnimalDto.fox(id)
                6 -> AnimalDto.raccoon(id)
                7 -> AnimalDto.cat(id)
                8 -> AnimalDto.lion(id)
                9 -> AnimalDto.tiger(id)
                10 -> AnimalDto.horse(id)
                11 -> AnimalDto.cow(id)
                12 -> AnimalDto.big(id)
                13 -> AnimalDto.boar(id)
                14 -> AnimalDto.mouse(id)
                15 -> AnimalDto.hamster(id)
                16 -> AnimalDto.rabbit(id)
                17 -> AnimalDto.polar(id)
                18 -> AnimalDto.koala(id)
                19 -> AnimalDto.panda(id)
                20 -> AnimalDto.chicken(id)
                21 -> AnimalDto.frog(id)
                else -> AnimalDto.dragon(id)
            }
            list.add(dto)
            id++
        }

        preCount = loadCount

        val searchedList = list.filter {
            it.designationKo.contains(search, true) || it.designationEn.contains(search, true)
        }

        return AnimalsResponse(page.times(perPage), searchedList, last)
    }
}
