package com.github.jhamin0511.mystudy.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.jhamin0511.mystudy.data.entity.UserEntity
import com.github.jhamin0511.mystudy.database.dao.UserDao

private const val APP_DATABASE_VERSION = 10

@Database(
    entities = [UserEntity::class],
    version = APP_DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        const val APP_DATABASE_NAME = "MyStudy.db"
    }

    abstract fun userDao(): UserDao
}
