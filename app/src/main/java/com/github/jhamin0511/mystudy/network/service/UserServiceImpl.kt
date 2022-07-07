package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.network.response.UserResponse

private const val CAL_TIME = 10000000L

class UserServiceImpl : UserService {
    private val serviceTime = System.currentTimeMillis()
    private var preCount: Int = 1
    private var id: Long = 1

    override suspend fun getUsers(page: Int, perPage: Int): UserResponse {
        if (page == 1) {
            preCount = 1
        }

        val list = mutableListOf<UserDto>()

        for (i: Int in preCount..page * perPage) {
            val createAt = serviceTime - i * CAL_TIME
            val user = UserDto(id++, UserType.getType(i), createAt, "name $i", i, "introduce $i")
            list.add(user)
        }

        preCount = page * perPage

        return UserResponse(page.times(perPage).toLong(), list)
    }
}
