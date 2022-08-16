package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.food.FoodDto
import com.github.jhamin0511.mystudy.network.response.FoodResponse

@Suppress("MaxLineLength", "MagicNumber", "LongMethod")
class FoodServiceImpl : FoodService {
    override suspend fun getFoods(): FoodResponse {
        val foods = listOf(
            FoodDto(
                1,
                "알탕",
                "₩12,000 ~ ₩15,000",
                R.drawable.img_altang,
                "호밍스 메인 요리는 집에서 직접 만들어 먹기 번거로운 구이, 전골, 볶음 등의 메뉴 12종으로 구성됐다. 언양식 바싹 불고기, 청송식 닭불고기, 서울식 소불고기전골, 부산식 곱창전골 등 제품이 인기를 끌고 있다. 급속 냉동 기술을 활용해 유통기한을 대폭 늘리고, 포장재 사용을 최소화해 기존 냉장 밀키트의 한계점을 보완했다. 식재료의 신선도와 유통기한은 물론, 제품의 맛과 친환경성까지 고려했다. 호밍스 메인 요리는 1년 만에 누적 판매량 200만 개, 누적 매출액 150억 원을 돌파했다. 호밍스 볶음밥 5종은 소비자들이 볶음밥 기름에 느끼는 부담을 덜기 위해 건강에 좋은 고품질 올리브유를 넣었다. 파기름을 함께 사용해 그윽한 불향을 입혔고, 밥알 하나하나를 급속 동결해 갓 볶아낸 볶음밥의 고슬고슬한 식감을 살렸다. 대상 관계자는 “호밍스는 기존 가정 간편식과는 차별화한 제품을 지속적으로 선보일 계획”이라고 말했다.",
                1,
                4,
                7
            ),
            FoodDto(
                2,
                "비빔밥",
                "₩10,000 ~ ₩13,000",
                R.drawable.img_bibimbap,
                "평양옥계각 임혜숙 경리(55)는 “해주비빔밥은 옛날 수양산성에서 외래침략자들을 반대하여 용감히 싸운 선조들의 투쟁이야기와 더불어 만들어진 것인데 여기에는 수양산에서 자란 고사리와 도라지, 참나물을 비롯한 산나물과 바다인삼으로 불리는 해삼, 옹진김을 비롯하여 조미료까지 다해서 19가지 음식감이 들어간다”고 알린다. 장분옥 요리사(42)는 “산과 들, 바다의 산해진미를 정성껏 가공하여 한 그릇에 담은 해주비빔밥은 보기에도 먹음직스럽고 맛도 하도 좋아 평양옥계각에 오는 손님들은 누구나 찾는 명요리로 인기가 높다”고 자랑한다.",
                23,
                55,
                12
            ),
            FoodDto(
                3,
                "부대찌개",
                "₩9,000 ~ ₩12,000",
                R.drawable.img_budaejjigae,
                "물가 상승도 판매량에 영향을 끼쳤다. 재료를 따로 구매하는 것보다 필요한 만큼 포장돼 있는 밀키트가 경제성이 높다고 소비자들은 판단했다. 실제 물가 상승이 본격화된 올해 5~6월 판매수량은 전년 동기 대비 32% 증가했다.\n" +
                    "\n" +
                    "hy 데이터 분석 조직 데이터센터에 따르면 밀키트 주 고객층은 40~50대로 나타났다. 단 2019년 66%였던 비율은 2022년 60.2%로 감소했다. 대신 20~30대 구매 비율은 26.1%에서 30.1%로 늘었다.\n" +
                    "\n" +
                    "요일별로는 주말 식사를 위해 목요일(21.9%)과 수요일(20.9%) 주문 건수가 가장 많았다. 제품 수령일은 목요일(20.3%)을 선호했다. hy 밀키트는 프레시 매니저를 통한 지정일 배송이 가능하다.\n" +
                    "\n" +
                    "올해 상반기 가장 많이 판매된 제품은 ‘논현동 부대찌개’다. 동일한 가격에 중량(20g)을 늘린 착한 밀키트로 입소문을 타며 지난해에 이어 1위에 올랐다. 부채살 찹스테이크와 현선이네 즉석떡볶이, 차돌박이 순두부찌개가 그 뒤를 이었다. 만족도의 바로미터인 재구매율은 2022년 기준 52%로 2019년 45% 대비 상승했다.\n" +
                    "\n" +
                    "이지은 hy 플랫폼CM팀장은 “엔데믹 이후 판매량이 감소할 것이라 예측 했던 밀키트가 편의성과 경제성을 강점으로 꾸준한 성장을 이어가고 있다”며 “hy만의 밀키트 경쟁력을 갖추기 위해 업종 간 협업 및 라인업 확대 등 다양한 노력을 기울이겠다”고 했다.",
                5429,
                3290,
                4558
            ),
            FoodDto(
                4,
                "불고기",
                "₩10,000 ~ ₩15,000",
                R.drawable.img_bulgogi,
                "종합식품기업 하림이 마늘간장과 고추장 양념으로 감칠맛을 살린 ‘광양식 닭불고기 순한맛’을 이마트 에브리데이 전 지점에서 판매한다.\n" +
                    "\n" +
                    "지난 3월 석쇠에 올려 바삭하게 구워 먹는 광양식 불고기를 재해석한 ‘광양식 닭불고기 매콤한맛’ 출시에 이어 라인업을 확대한 것. 신선한 닭고기의 부드러운 순살을 한입에 먹기 좋게 저민 다음 하림만의 노하우로 담백하게 양념한 제품이다. 요즘처럼 더운 날씨에 짭조름한 양념이 잘 밴 닭불고기는 가족 모두의 입맛을 돋을 수 있는 한 끼 반찬으로 제격이다.\n" +
                    "\n" +
                    "조리법도 간단하다. 프라이팬에 식용유를 적당히 두르고, 광양식 닭불고기를 중불에서 익히기만 하면 된다. 기호에 따라 양파, 대파 등을 추가하면 더욱 푸짐하게 즐길 수 있다. 또한 참기름이 함께 들어 있어 남은 양념으로 고소한 볶음밥을 만들어 먹어도 좋다. 1팩에 7980원(400g).",
                3312,
                2234,
                1111
            ),
            FoodDto(
                5,
                "참치회",
                "₩35,000 ~ ₩450,000",
                R.drawable.img_chamchi_hoe,
                "고기를 대체하는 대체육에 이어 생선과 비슷한 맛을 구현한 '대체 해산물'을 개발하는 스타트업들이 늘고 있다. 대체육 간편식 스타트업 브라잇벨리가 참치 대체육을 개발했다고 14일 발표했다. 브라잇벨리는 대체육 소고기를 활용한 함박스테이크를 스타벅스와 커피빈 등 카페 프랜차이즈에 납품해온 회사다.\n" +
                    "\n" +
                    "브라잇벨리가 새롭게 개발한 참치육은 100% 식물성 원료로 만든 것이다. 김지현 브라잇벨리 대표는 \"식물성 식사를 대중화하고 소비자에게 더 넓은 채식 선택권을 선사하고자 한다\"고 했다. 참치 대체육은 샌드위치나 김밥 등 다양한 간편식과 요리에 활용될 예정이다.",
                1983,
                2448,
                3384
            ),
            FoodDto(
                6,
                "치킨",
                "₩4,900 ~ ₩40,000",
                R.drawable.img_chicken,
                "지난 16일 전국 홈플러스 매장엔 한바탕 소동이 벌어졌다. 초복을 맞아 프라이드치킨 한 마리를 4990원에 특가로 판매한다는 입소문이 나 소비자들이 매장으로 몰려들면서다. 오후 3시 치킨을 판매하기 전부터 매장엔 긴 줄이 늘어섰다. 전 점포에 한정 수량으로 준비한 5000마리는 판매를 시작한 지 한 시간여 만에 동났다. 홈플러스 관계자는 \"외식 물가 급등으로 주머니 사정이 팍팍한 소비자들이 대거 몰리면서 '치킨런(치킨+오픈런)'이라는 신조어까지 생겼다\"고 말했다. 19일 유통업계에 따르면 최근 외식 물가는 물론 배달비까지 급등하면서 배달음식을 시켜 먹거나 외식을 하는 대신 대형마트 델리(조리식품) 코너를 찾는 소비자가 늘어나고 있다. 유통업체들도 맛과 가격을 모두 잡은 '가성비(가격 대비 성능)' 델리 메뉴를 개발해 선보이며 소비자를 매장으로 불러들이고 있다.",
                2345,
                61234,
                1234
            ),
            FoodDto(
                7,
                "닭도리탕",
                "₩28,000 ~ ₩48,000",
                R.drawable.img_dakdoritang,
                "등산로 어귀에서 파는 메뉴가 한국인이 가장 좋아하는 음식일지도 모른다. 땀 흘리고 몸이 힘들 때, 이성이 작동하지 않을 때 본능적으로 찾게 되는 음식, 그중 하나가 닭볶음탕이다. 예전 동생과 나도 그랬다. 닭도리탕이라 부르던 닭볶음탕이 밥상에 오르면 동생과 나는 전쟁 모드였다. 아버지가 출발 신호를 주듯 닭다리 하나를 집어 들면 그때부터 칼싸움 하듯 젓가락질을 했다. 전분이 흩어져 걸쭉해진 국물을 밥에 비비고 빨간 김치를 올렸다. 전력질주를 하고 난 주자처럼 숨을 헐떡이며 뒤로 손 디뎌 기대앉으면 식사가 끝났다. 그 쾌감과 포만감은 2002년 월드컵처럼 여전히 생생하게 기억에 남았다.",
                66124,
                12342,
                1244
            ),
            FoodDto(
                8,
                "닭찜",
                "₩30,000 ~ ₩50,000",
                R.drawable.img_dakjjime,
                "홍콩은 일년 내내 즐길거리로 가득하다. 그중에서도 온화한 기후와 화려한 축제가 함께하는 연말은 특히 반짝인다. 세계적인 규모의 쇼핑몰들이 선보이는 대형 크리스마스 트리와 밤하늘을 수놓는 레이저쇼는 로맨틱한 분위기를 선사한다. 화려한 조명이 가득한 홍콩의 핫한 나이트 라이프도 매력적이며, 침사추이부터 센트럴까지 홍콩의 주요 거리에서는 캐롤이 울려퍼진다. 올해는 서구룡문화지구에 조성된 크리스마스 타운을 주목해보자. 지난해까지 센트럴 타운에 세워졌던 초대형 크리스마스 트리를 옮겨온 데다 12월31일 새해 카운트 다운 행사도 진행될 예정이다",
                612436,
                12355,
                21342
            ),
            FoodDto(
                9,
                "된장찌개",
                "₩8,000 ~ ₩12,800",
                R.drawable.img_doenjangjjigae,
                "한국미술응원프로젝트는 스타 작가 탄생에 초점을 맞춘 다른 공모전과 달리 민주적으로 작가를 발굴해 미술계의 텃밭을 기름지게 하려는 것이 목표다. 따라서 특정 경향이나 장르 혹은 미술 활동 경력, 나이에 상관없이 대상 작가의 스펙트럼이 넓다. 일곱 번의 시즌을 통해 180여 명의 작가를 발굴했다. 이 중에는 미술계에 첫발을 내딛은 작가가 있는가 하면, 활동 경력이 풍부한 작가도 있었다. 미술시장의 주목을 받게 된 작가도 나왔고, 작품 활동의 모멘트가 된 작가도 있었다. 무엇보다도 프로젝트 출신 작가들이 ‘한국미술응원프로젝트협회’를 만들어 활발히 활동하고 있다는 게 가장 큰 결실이다.",
                431,
                423,
                219
            ),
            FoodDto(
                10,
                "돼지국밥",
                "₩9,000 ~ ₩18,000",
                R.drawable.img_dwaejigukbap,
                "하지만 뜨끈한 고기육수와 쫄깃한 돼지 앞다리살, 신김치와 부추의 조화, 마지막 사리 추가까지 ‘집밥 풀코스’를 맛보게 돼 다음부터는 입구에 들어설 때부터 “짜글이 두 개요”하고 들어가는 게 버릇이 됐습니다(사리는 공짜, 공깃밥은 무한리필입니다. ^^).",
                143,
                223,
                319
            ),
            FoodDto(
                11,
                "돼지수육",
                "₩30,000 ~ ₩60,000",
                R.drawable.img_dwaejisuyuk,
                "이 같은 편의점 안주·주류 매출 상승은 무더위라는 계절성 외에도 최근 크게 오른 음식 배달비의 반사 이익도 반영됐다는 분석이다. CU의 경우 멤버십 앱 ‘포켓CU’에서 미리 상품을 주문하면 원하는 시간에 점포에 들러 준비된 상품을 픽업할 수 있는 ‘편픽’ 서비스를 운영하는데, 별도 수수료가 없어 퇴근길에 주문 상품을 받아가려는 직장인들이 많다. 최근 한 치킨 프랜차이즈가 배달료를 크게 인상한 것은 물론 주요 음식 배달 플랫폼의 배달 비용이 부담되는 수준까지 치솟은 가운데 알뜰 소비에 나선 고객들이 편의점을 대안으로 삼고 나선 것이다. 실제로 편픽 서비스는 퇴근 시간인 오후 6시부터 야식을 즐기는 23시까지 하루 매출의 약 60%가 집중됐으며 배달 라이더 매칭이 어려운 우천 시 이용 건수가 맑은 날 대비 15%가량 많았다. 주요 구매 품목은 배달 주문이 제한되는 맥주, 소주, 와인 등 주류와 컵얼음, 탄산음료, 스낵, 냉장안주, 디저트 순으로 나타났다. 조성해 BGF리테일(282330) Q-커머스팀장은 “외식비, 배달비 등 물가 인상이 이어지면서 합리적인 가격에 커리티 높은 음식을 간편하게 구매할 수 있는 CU를 찾는 고객들이 늘고 있다”며 “앞으로도 CU는 고객들이 보다 편리하고 합리적인 소비를 할 수 있도록 다양한 상품과 서비스를 확장해 나갈 것”이라고 말했다.",
                443,
                423,
                419
            ),
            FoodDto(
                12,
                "갈비찜",
                "₩20,000 ~ ₩40,000",
                R.drawable.img_galbijjim,
                "송고버섯을 아낌없이 넣은 맛간장은 갈비의 느끼한 기름 맛을 싹 잡아준다. 젊은 시절부터 채소 운수업을 했던 주인장은 쉰의 나이에 퇴직을 하고 제2의 인생을 살기 위해 과감히 요식업에 뛰어들었다는데 손님들에게 맛으로 인정받기까지 우여곡절도 많았지만 포기하지 않고 끊임없이 연구에 연구를 거듭했다는 주인장.",
                243,
                223,
                219
            ),
            FoodDto(
                13,
                "고등어 구이",
                "₩14,000 ~ ₩18,000",
                R.drawable.img_godeungeogui,
                "이 같은 편의점 안주·주류 매출 상승은 무더위라는 계절성 외에도 최근 크게 오른 음식 배달비의 반사 이익도 반영됐다는 분석이다. CU의 경우 멤버십 앱 ‘포켓CU’에서 미리 상품을 주문하면 원하는 시간에 점포에 들러 준비된 상품을 픽업할 수 있는 ‘편픽’ 서비스를 운영하는데, 별도 수수료가 없어 퇴근길에 주문 상품을 받아가려는 직장인들이 많다. 최근 한 치킨 프랜차이즈가 배달료를 크게 인상한 것은 물론 주요 음식 배달 플랫폼의 배달 비용이 부담되는 수준까지 치솟은 가운데 알뜰 소비에 나선 고객들이 편의점을 대안으로 삼고 나선 것이다. 실제로 편픽 서비스는 퇴근 시간인 오후 6시부터 야식을 즐기는 23시까지 하루 매출의 약 60%가 집중됐으며 배달 라이더 매칭이 어려운 우천 시 이용 건수가 맑은 날 대비 15%가량 많았다. 주요 구매 품목은 배달 주문이 제한되는 맥주, 소주, 와인 등 주류와 컵얼음, 탄산음료, 스낵, 냉장안주, 디저트 순으로 나타났다. 조성해 BGF리테일(282330) Q-커머스팀장은 “외식비, 배달비 등 물가 인상이 이어지면서 합리적인 가격에 커리티 높은 음식을 간편하게 구매할 수 있는 CU를 찾는 고객들이 늘고 있다”며 “앞으로도 CU는 고객들이 보다 편리하고 합리적인 소비를 할 수 있도록 다양한 상품과 서비스를 확장해 나갈 것”이라고 말했다.",
                143,
                123,
                119
            ),
            FoodDto(
                14,
                "고등어 조림",
                "₩15,000 ~ ₩20,000",
                R.drawable.img_godeungeojorim,
                " 소설 ‘별들의 고향’으로 장안의 주가를 올린 소설가 최인호는, 암으로 세상을 버렸다. 그는 임종 직전, 친구들에게 농담을 했다. “세상과 하직한다 해서 서운한 건 하나도 없다, 나는 그 있잖아, (서울) 한일관 갈비탕 못 먹게 되어 그게 가장 아쉬워, 정말 아쉬워, 저세상엔 갈비탕이 없겠지?",
                343,
                323,
                319
            ),
            FoodDto(
                15,
                "회",
                "₩10,000 ~ ₩500,000",
                R.drawable.img_hoe,
                "한번 맛보면 잊지 못하고 단골이 된다. 이곳의 또 다른 별미는 떨어진 입맛을 살리는 매운갈비찜이다. 매콤한 양념 옷을 두른 갈비와 각종 채소와 버섯종류가 쫄깃 쫄깃한 식감으로 기력을 보충해준다.",
                543,
                523,
                519
            ),
            FoodDto(
                16,
                "칼국수",
                "₩10,000 ~ ₩18,000",
                R.drawable.img_kalguksu,
                "1. 밀가루에 물과 소금을 약간 넣고 반죽해 숙성시킨 뒤 썬다.\n" +
                    "2. 애호박, 당근은 채를 썬다.\n" +
                    "3. 양념장을 만든다.\n" +
                    "4. 냄비에 물과 육수용 재료를 넣고 끓여 육수를 만든다.\n" +
                    "5. 바지락은 물에 담가 문질러 씻은 후 헹궈 체에 받쳐 둔다.\n" +
                    "6. 냄비에 육수, 바지락을 넣고 끓어 오르면 애호박, 당근을 넣고 끓인다.\n" +
                    "7. 칼국수 면, 소금을 넣고 면이 익을 때까지 끓인다.\n" +
                    "8. 양념장을 곁들인다.",
                463,
                623,
                196
            ),
            FoodDto(
                17,
                "김치찌개",
                "₩10,000 ~ ₩13,000",
                R.drawable.img_kimchijjigae,
                "부안군 변산반도는 동쪽을 제외한 3면이 바다와 접해 갯벌이 발달해 있고, 일찍부터 차진 갯벌에서 잡히는 조개류를 식재료로 활용한 음식들이 발달했다.\n" +
                    "대표적인 것이 바지락으로 바지락칼국수와 바지락죽 외에도 무침, 전, 비빔밥, 탕 등으로 다양하게 활용되고 있다.",
                643,
                623,
                619
            ),
            FoodDto(
                18,
                "꽃게탕",
                "₩10,000 ~ ₩13,000",
                R.drawable.img_kkotgetang,
                "이맘때 외연도는 1년 중 제일 바쁠 때. 수심이 깊고 육지에서 먼 청정해역으로 해삼과 전복의 대표 산지로 이름이 나있다. 5월부터 6월까지, 일명 ‘해삼바리’ 해삼 철에는 해녀들이 제주도에서 원정을 올 정도. 그중엔 제주에서 물질을 나왔다 외연도 총각을 만나 정착한 해녀들도 있다.\n" +
                    "\n" +
                    "김이 잘 서리지 않도록 쑥으로 물안경을 꼼꼼하게 닦고 기운을 북돋아줄 달달한 커피 한 잔이면 준비 완료! 거센 물살을 이겨가며 바삐 움직이다 보면 손 하나 까딱하기 싫을 만큼 녹초가 된다.\n" +
                    "\n" +
                    "오늘은 거두어 팔기 바빴던 해삼으로 해녀들의 특별 메뉴를 선보인다는데. 오랜 물질에 입안이 퉁퉁 불어 매운 음식을 못 먹는 해녀들은 고춧가루 조금, 설탕과 식초는 넉넉하게 넣은 양념에 해삼을 넣고 버무리면 쉽고 간단하지만 맛 있으면 그만! 해녀들의 간편식 해삼 물회가 완성된다.\n" +
                    "\n" +
                    "돌미역과 홍합을 넣고 달달 볶다가 홍합 삶은 육수를 넣고 푹 끓인 홍합미역국. 해삼보다 귀한 대접 받았던 전복은 양념장을 올린 찜과 죽으로 물질로 허해진 몸을 달래주었다. 제주에서 서해 끝섬까지 바다가 맺어준 인연들의 귀한 밥상을 만나본다.",
                743,
                723,
                719
            ),
            FoodDto(
                19,
                "모든전",
                "₩30,000 ~ ₩45,000",
                R.drawable.img_modumjeon,
                "60년이 넘는 세월동안 내 집 마당처럼 넘나들던 바다이기에 안 봐도 훤하다는데 고깔모자처럼 생긴 ‘꾀까리’와 달처럼 동그랗게 생겨 ‘달배’라고 불리는 섬까지 외연도를 중심으로 크고 작은 섬들이 외연열도를 이룬다. 수십년 전 이주 정책으로 황도에서 외연도로 이주해온 이상모 씨. 총각시절 황도의 너른 평지에서 소 키우던 시절이 엊그제 같은데 흐른 세월이 야속하다.",
                743,
                237,
                179
            ),
            FoodDto(
                20,
                "냉면",
                "₩9,000 ~ ₩18,000",
                R.drawable.img_naengmyeon,
                "외연도에서 나고 자라 평생을 살아온 이선화 씨와 박재순 씨는 섬에서도 소문난 일부자. 해삼 철이면 버려지는 내장이 아까워 일일이 손으로 훑어가며 펄을 빼내는 작업을 하느라 온몸엔 파스냄새가 진동한다고. 그렇게 얻은 해삼 내장은 먹기 좋게 잘라 참기름 한바퀴 두르고 참깨, 다진 고추를 넣어 버무리면 다른 반찬 없이 밥 한 그릇 뚝딱! 입안을 가득 채우는 바다향에 한 번만 먹어본 사람은 없다는 해삼내장무침이다.",
                843,
                238,
                819
            ),
            FoodDto(
                21,
                "삼겹살",
                "₩16,000 ~ ₩23,000",
                R.drawable.img_samgyeopsal,
                "삼겹살을 전문으로 하는 한식프랜차이즈 하남돼지집이 2022년 하반기를 맞아 한시적 창업프로모션을 진행한다고 밝혔다. 올 하반기 가맹비를 1500만원대에서 300만원대으로 축소하고 교육비 또한 200만원대를 지원함으로써 약 1500만원대 이상의 창업 할인 혜택을 제공한다.",
                943,
                923,
                919
            ),
            FoodDto(
                22,
                "삼계탕",
                "₩15,000 ~ ₩18,000",
                R.drawable.img_samgyetang,
                "A RecyclerView addon library providing support for item selection. The library provides support for both touch and mouse driven selection. Developers retain control over the visual representation, and the policies controlling selection behavior (like which items are eligible for selection, and how many items can be selected.)",
                1043,
                2103,
                1910
            )
        )
        return FoodResponse(23, foods)
    }
}
