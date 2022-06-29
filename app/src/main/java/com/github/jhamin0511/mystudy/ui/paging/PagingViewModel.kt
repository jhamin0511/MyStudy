package com.github.jhamin0511.mystudy.ui.paging

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.jhamin0511.mystudy.viewmodel.Event
import com.github.jhamin0511.mystudy.viewmodel.event
import com.github.jhamin0511.mystudy.widget.recycler.Item
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val PER_PAGE = 30

@HiltViewModel
class PagingViewModel
@Inject constructor(
) : ViewModel() {

    // region Binding
    fun bindClickFab() {
        // no-op comment in an unused listener function
    }
    // endregion

    // region Observe
    val observeUser = MutableLiveData<Event<List<Item>>>()
    // endregion

    // region Model
    private var preCount = 1
    private var getListCount = 1

    fun getList(count: Int): List<Item> {
        val list = mutableListOf<UserItem>()

//        for (i: Int in preCount..count * getListCount) {
//            val icon = when (i % 5) {
//                0 -> R.drawable.ic_face
//                1 -> R.drawable.ic_face2
//                2 -> R.drawable.ic_face3
//                3 -> R.drawable.ic_face4
//                else -> R.drawable.ic_face5
//            }
//            val user = UserItem(
//                i.toLong(),
//                icon,
//                "2022.06.22",
//                "user$i",
//                i % 19,
//                " $i : introduce my informations every body rounderisei la la la la la roule wero"
//            )
//            list.add(user)
//        }

        preCount = count * getListCount
        getListCount++

        return list.groupBy { it.createdAt }.flatMap { group ->
            val users = group.value.map { user ->
                UserItem(user.id, user.icon, user.createdAt, user.name, user.age, user.introduce)
            }
            mutableListOf<Item>().apply {
                add(DateItem(group.key))
                addAll(users)
            }
        }
    }

    init {
        observeUser.event(getList(PER_PAGE))
    }
    // endregion
}
