package com.github.jhamin0511.mystudy.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.data.dto.user.UserType

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Long,
    @ColumnInfo(name = "type")
    val type: UserType,
    @ColumnInfo(name = "createAt")
    val createAt: Long,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "age")
    val age: Int,
    @ColumnInfo(name = "introduce")
    val introduce: String,
    @ColumnInfo(name = "content")
    val content: String
) {
    companion object {
        fun create(dtos: List<UserDto>): List<UserEntity> {
            return dtos.map {
                create(it)
            }
        }

        fun create(dto: UserDto): UserEntity {
            return UserEntity(
                dto.id,
                dto.type,
                dto.createAt,
                dto.name,
                dto.age,
                dto.introduce,
                dto.content
            )
        }
    }
}
