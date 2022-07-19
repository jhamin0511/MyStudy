package com.github.jhamin0511.mystudy.database.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.jhamin0511.mystudy.data.entity.UserEntity

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(entities: List<UserEntity>)

    @Query("SELECT * FROM user ORDER BY date DESC")
    fun selectAll(): PagingSource<Int, UserEntity>

    @Query("SELECT * FROM user WHERE id=:id")
    suspend fun selectById(id: Long): UserEntity?

    @Query("SELECT date FROM user WHERE id=:id")
    suspend fun selectDateById(id: Long): Long

    @Query("UPDATE user set date=:date, introduce=:introduce, content=:content  WHERE id=:id")
    suspend fun update(id: Long, date: Long, introduce: String, content: String)

    @Query("DELETE FROM user")
    suspend fun deleteAll()
}
