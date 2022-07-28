package com.github.jhamin0511.mystudy.widget.recycler.source

import androidx.lifecycle.MutableLiveData
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.jhamin0511.mystudy.data.dto.Dto
import com.github.jhamin0511.mystudy.widget.recycler.Item
import com.google.common.truth.Truth.assertThat
import com.google.gson.annotations.SerializedName
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class DataSourceTest {
    companion object {
        private val data = UserDto(1, "name1", 1, "address1")
    }

    private val liveData = MutableLiveData<List<Item>>()
    private val dataSource = UserDataSource(liveData)

    @Test
    fun get_alreadyAdded_assertThat() {
        // Given
        dataSource.add(data)
        // When
        val actual = dataSource.get(data.id)
        // Then
        assertThat(actual).isEqualTo(data)
    }

    @Test
    fun set_dataList_assertThat() {
        // Given
        dataSource.add(UserDto(2, "name2", 2, "address2"))
        val dataList = listOf(data)
        // When
        dataSource.set(dataList)
        // Then
        val actual = dataSource.get(data.id)
        val size = dataSource.size()
        assertThat(actual).isEqualTo(data)
        assertThat(size).isEqualTo(1)
    }

    @Test
    fun addAll_dataList_assertThat() {
        // Given
        val dataList = listOf(data)
        // When
        dataSource.addAll(dataList)
        // Then
        val actual = dataSource.get(data.id)
        assertThat(actual).isEqualTo(data)
    }

    @Test
    fun remove_hasData_assertThat() {
        // Given
        dataSource.add(data)
        // When
        val actual = dataSource.remove(data.id)
        // Then
        assertThat(actual).isNotNull()
        assertThat(actual).isEqualTo(data)
    }

    @Test
    fun remove_noneData_assertThat() {
        // Given
        dataSource.add(data)
        // When
        val actual = dataSource.remove(2)
        // Then
        assertThat(actual).isNull()
    }

    @Test
    fun update_hasData_assertThat() {
        // Given
        dataSource.add(data)
        val expected = UserDto(1, "name11", 11, "address11")
        // When
        val actual = dataSource.update(expected)
        // Then
        assertThat(actual).isNotNull()
        assertThat(actual).isEqualTo(data)
    }

    @Test
    fun update_noneData_assertThat() {
        // Given
        val expected = UserDto(2, "name22", 22, "address11")
        // When
        val actual = dataSource.update(expected)
        // Then
        assertThat(actual).isNull()
    }

    @Test
    fun clear_assertThat() {
        // Given
        dataSource.add(data)
        // When
        dataSource.clear()
        // Then
        val actual = dataSource.size()
        assertThat(actual).isEqualTo(0)
    }
}

data class UserDto(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("age")
    val age: Int,
    @SerializedName("address")
    val address: String
) : Dto {
    override fun id(): Long {
        return id
    }
}

data class UserItem(
    val id: Long,
    val name: String,
    val age: Int,
    val address: String
) : Item {
    override fun id(): Long {
        return id
    }

    companion object {
        fun create(value: UserDto): UserItem {
            return UserItem(
                value.id,
                value.name,
                value.age,
                value.address
            )
        }

        fun create(values: List<UserDto>): List<UserItem> {
            return values.map { create(it) }
        }
    }
}

class UserDataSource(
    private val liveData: MutableLiveData<List<Item>>
) : DataSource<UserDto>() {
    override fun submit(values: List<UserDto>) {
        liveData.value = UserItem.create(values)
    }
}
