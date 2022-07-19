package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.data.dto.user.UserDto
import com.github.jhamin0511.mystudy.data.dto.user.UserType
import com.github.jhamin0511.mystudy.network.response.UserResponse

private const val CAL_TIME = 14000000L
private const val END_PAGE = 10
private const val DIV_SIZE = 5
private const val CONTENT1_TYPE = 1
private const val CONTENT2_TYPE = 2
private const val CONTENT3_TYPE = 3
private const val CONTENT4_TYPE = 4
private const val CONTENT1 = "경로, 딥 링크 및 인수가 포함된 URI를 문자열에서 파싱할 수 있습니다. 위의 표" +
        "에서 보는 바와 같이 Parcelable 및 Serializable과 같은 맞춤 데이터 유형은 사용할 수 없습니다. 맞춤" +
        " 복합 데이터를 전달하려면 ViewModel 또는 데이터베이스와 같은 다른 위치에 데이터를 저장하고 탐색 중에" +
        " 식별자만 전달한 다음 탐색이 완료된 후 새로운 위치에서 데이터를 회수합니다."
private const val CONTENT2 = "대상 레벨 인수 및 기본값은 대상을 탐색하는 모든 작업에서 사용됩니다. 필요한 " +
        "경우 작업 레벨에서 인수를 정의하여 인수의 기본값을 재정의하거나 존재하지 않는 경우 설정할 수 있습니다." +
        " 이 인수는 대상에서 선언된 인수와 동일한 이름과 유형이어야 합니다."
private const val CONTENT3 = "탐색 구성요소에는 Safe Args라는 Gradle 플러그인이 있어서 모든 연결된 인수에" +
        " 유형 안전성을 갖춘 탐색 및 액세스를 하기 위한 간단한 객체 및 빌더 클래스를 생성합니다. Safe Args는" +
        " 유형 안전성을 보장하므로 데이터를 탐색하고 전달할 때는 Safe Args를 사용하는 것이 좋습니다."
private const val CONTENT4 = "이러한 대상 중 하나로 이동할 때 Dynamic Navigator 라이브러리는 먼저, 기능" +
        " 모듈이 설치되어 있는지 확인합니다. 기능 모듈이 이미 있다면 앱은 예상대로 대상으로 이동합니다. 모듈이" +
        " 없다면 앱은 모듈을 설치할 때 중간 진행률 프래그먼트 대상을 표시합니다. 진행률 프래그먼트의 기본 구현은" +
        " 진행률 표시줄이 있는 기본 UI를 표시하고 모든 설치 오류를 처리합니다."
private const val CONTENT5 = "여러 라이브러리 모듈이 로그인 그래프와 같은 일반적인 대상 집합을 참조해야 하는" +
        " 경우 이러한 일반적인 대상을 각 라이브러리 모듈의 탐색 그래프에 포함하면 안 됩니다. 대신 이러한 일반적" +
        "인 대상을 app 모듈의 탐색 그래프에 추가하세요. 그러면 각 라이브러리 모듈이 라이브러리 모듈 전체를 탐색" +
        "하여 이러한 일반적인 대상으로 이동할 수 있습니다."

class UserServiceImpl : UserService {
    private val serviceTime = System.currentTimeMillis()
    private var preCount: Int = 1
    private var id: Long = 1

    override suspend fun getUsers(page: Int, perPage: Int): UserResponse {
        val list = mutableListOf<UserDto>()
        val loadCount = preCount.plus(perPage)
        val last = page == END_PAGE

        for (i: Int in preCount until loadCount) {
            val createAt = serviceTime - i * CAL_TIME
            val content = when (i % DIV_SIZE) {
                CONTENT1_TYPE -> CONTENT1
                CONTENT2_TYPE -> CONTENT2
                CONTENT3_TYPE -> CONTENT3
                CONTENT4_TYPE -> CONTENT4
                else -> CONTENT5
            }
            val user = UserDto(
                id++,
                UserType.getType(i),
                createAt,
                "name $i",
                i,
                "introduce $i",
                content
            )
            list.add(user)
        }

        preCount = loadCount

        return UserResponse(page.times(perPage).toLong(), list, last)
    }
}
