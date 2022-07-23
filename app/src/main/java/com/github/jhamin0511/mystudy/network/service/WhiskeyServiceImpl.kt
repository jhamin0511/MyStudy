package com.github.jhamin0511.mystudy.network.service

import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.github.jhamin0511.mystudy.network.response.WhiskeyResponse

@Suppress("MaxLineLength", "MagicNumber", "LongMethod")
class WhiskeyServiceImpl : WhiskeyService {

    companion object {
        private const val TERM_OF_TIME = 100000L
    }

    override suspend fun getWhiskeys(): WhiskeyResponse {
        val currentTime = System.currentTimeMillis()

        val whiskeys = listOf(
            WhiskeyDto(
                1,
                currentTime,
                R.drawable.img_jimbeam,
                "짐빔",
                "40,680원",
                "오랜 역사와 전통을 자랑하는 짐빔은 미국 버번위스키를 대표하는 브랜드입니다. 그 중에서도 '짐빔 화이트'는 엄청난 가성비를 지닌 제품입니다. 버번의 개성을 갖췄으면서도 저렴한 가격 덕에 전 세계에서 사랑받고 있으며 미국의 소주라고도 불릴 수 있을만큼 대중적인 술입니다. 스트레이트로 마셔도 좋지만, 탄산수나 콜라를 섞어 마시는 것도 추천드립니다. 오늘, 기분좋게 취하고 싶다면 짐빔과 함께하시는건 어떨까요.",
                WhiskeyTaste.ROW,
                bookmark = false,
                favorite = false,
                follow = true
            ),
            WhiskeyDto(
                2,
                currentTime - 2 * TERM_OF_TIME,
                R.drawable.img_makersmark,
                "메이커스 마크",
                "77,400원",
                "메이커스 마크는 미국의 프리미엄 버번 위스키 브랜드 중 하나입니다. 옥수수 70%, 밀 16%, 맥아보리 14%로 만들어진 메이커스 마크는 일반 호밀이 아닌 가을밀을 사용하여 풍부하고 균형잡힌 맛을 냅니다. '스파이시함'과 '높은 도수'가 일반적인 버번 위스키의 특징이라면, 메이커스 마크는 여기에 바닐라향과 카라멜향까지 놓치지 않았습니디. 특유의 버번 오크향과 가볍지 않은 바디감, 그 강렬함 안에 부드러움까지 담아낸 메이커스 마크의 섬세함은 버번 위스키 입문으로 가장 인기있는 이유입니다.\n\n메이커스 마크는 스트레이트로 즐겨도 좋고 콜라를 넣어 버번 콕으로 즐기시거나 탄산수를 넣어 하이볼로 즐기시기에도 좋습니다. 가격 역시 합리적이니, 위스키에 대해 알아보고자 하시는 분께는 첫 위스키로도 추천드립니다.",
                WhiskeyTaste.MIDDLE,
                bookmark = true,
                favorite = false,
                follow = false
            ),
            WhiskeyDto(
                3,
                currentTime - 3 * TERM_OF_TIME,
                R.drawable.img_jimbeam,
                "와일드 터키",
                "79,200원",
                "와일드 터키 8년은 '버번 입문 3대장'으로 유명한 미국의 프리미엄 버번 위스키입니다. 과거 유명하지 않던 시절, 야생 칠면조 사냥에 이 위스키를 가져가서 호평을 받았던것이 유래가 되어 와일드 터키라는 이름이 만들어졌다고 하네요. 와일드 터키 8년은 다른 버번 3대장들에 비해 높은 도수와 강렬한 맛을 가지고 있는것이 특징입니다. 또한 기존 와일드 터키 101(6~8년 숙성 원액 사용)에 비해 고숙성 원액을 사용하여 더 진하고 강한 맛을 즐길 수 있습니다.",
                WhiskeyTaste.MIDDLE,
                bookmark = true,
                favorite = true,
                follow = false
            ),
            WhiskeyDto(
                4,
                currentTime - 4 * TERM_OF_TIME,
                R.drawable.img_jimbeam,
                "버팔로 트레이스",
                "77,400원",
                "",
                WhiskeyTaste.MIDDLE,
                bookmark = true,
                favorite = true,
                follow = false
            ),
            WhiskeyDto(
                5,
                currentTime - 5 * TERM_OF_TIME,
                R.drawable.img_buffalotrace,
                "버팔로 트레이스",
                "77,400원",
                "고대 버팔로 자취를 따라 국경을 발견한 미국 개척자들의 야수성, 독립 정신을 기리며 만들어진 스트레이트 버번 위스키, '버팔로 트레이스'는 메이커스 마크, 와일드 터키와 함께 버번 위스키 입문 3대장 중 하나로 불립니다.\n\n버팔로 트레이스는 켄터키 주와 인디아나 주의 옥수수, 호밀, 몰트를 이용해서 만들었습니다. 이원액을 아메리칸 오크통에서 6~8년 숙성해서 병에 담았죠. 오랜 숙성 기간이 말해주듯, 버팔로 트레이스는 매우 부드러운 풍미가 특징인데요. 거친 야생 버팔로의 느낌과는 다르게 순한 송아지의 인상을 가지고 있디고 합니다. 덕분에 올드 패션드와 같은 클래식 칵테일에 가장 잘 어울리고요. 니트로 마실 때에도 바닐라와 오크 향을 부드럽게 음미할 수 있습니다.",
                WhiskeyTaste.MIDDLE,
                bookmark = true,
                favorite = false,
                follow = true
            ),
            WhiskeyDto(
                6,
                currentTime - 6 * TERM_OF_TIME,
                R.drawable.img_jimbeam,
                "버팔로 트레이스",
                "77,400원",
                "",
                WhiskeyTaste.MIDDLE,
                bookmark = true,
                favorite = true,
                follow = false
            ),
            WhiskeyDto(
                7,
                currentTime - 7 * TERM_OF_TIME,
                R.drawable.img_1792smallbatch,
                "1792 스몰 배치",
                "95,400원",
                "1792 스몰배치는 1792년 켄터키 주가 미국 연방에 편입된 해를 기념하기 위해 만들어졌습니다. 마스터 블렌더가 고심 끝에 선별한 오크통에서 9년 이상의 숙성 과정을 거치고, 높은 호밀 비율의 특별한 메시빌을 통해 복합적인 버번 위스키의 풍미를 구현하였습니다. 1792 스몰배치는 강렬한 스파이스함과 함께 놀라울 정도의 부드러운 맛과 향을 지니고 있는 버번 위스키입니다. Jim Murray의 <위스키 바이블>에서 92.5점의 평점을 얻으며 그 가치를 인정받은 위스키이기도 합니다.",
                WhiskeyTaste.HIGH,
                bookmark = true,
                favorite = true,
                follow = true
            ),
            WhiskeyDto(
                8,
                currentTime - 8 * TERM_OF_TIME,
                R.drawable.img_evanwilliamsblack,
                "에반 윌리엄스 블랙",
                "28,000원",
                "에발 윌리엄스 블랙은 붉은 빛이 살짝 감도는 호박색 위스키입니다. 잔을 들면 깊은 바닐라와 민트 향을 코끝에서 느낄 수 있습니다. 오크, 흑설탕, 캐러멜의 풍미가 어우러지며 긴 여운을 남겨 그냥 가벼게 마시기에도, 음료와 섞어 마시기에도 적절합니다.\n\n에반윌리엄스 블랙은 스트레이트 버번으로 인정받기 위한 법적 수성기간인 2년 보다 긴 4~5년간 숙성하여 더욱 부드럽고 풍부한 향을 지니고 있으며, 높은 알코올 도수를 지녀 버번 위스키 특유의 강렬한 풍미를 기대할 수 있습니다.",
                WhiskeyTaste.BAD,
                bookmark = false,
                favorite = true,
                follow = false
            ),
            WhiskeyDto(
                9,
                currentTime - 9 * TERM_OF_TIME,
                R.drawable.img_larceny,
                "라세니 스몰배치",
                "79,000원",
                "밝은 구리색을 띠고 있으며, 신선한 빵과 토피, 버터스카치 향과 감미로운 캐러멜 맛, 꿀처럼 달콤한 여운이 입 안을 풍성하게 채워준다. 기분 좋은 단 향이 긴 여운으로 남는다. \n" +
                    "\n" +
                    "옥수수를 주 곡물로 해, 라이(rye) 대신 밀을 사용했으며 그 함유량이 맥아보리보다 높아 비슷한 급의 버번 위스키에 비해 월등하게 부드럽고 섬세한 맛을 가졌다. \n" +
                    "\n" +
                    "약 2백개의 선별한 배럴 분량으로만 만드는 위스키로, 2008년 런칭 후 프리미엄 버번 시장에서 뜨거운 인기를 누리고 있다. 2020년 San Francisco World Spirits Competition에서 금메달을 수상하는 등 전문가들의 호평도 이어지고 있다. ",
                WhiskeyTaste.MIDDLE,
                bookmark = true,
                favorite = true,
                follow = false
            ),
            WhiskeyDto(
                10,
                currentTime - 10 * TERM_OF_TIME,
                R.drawable.img_elijahcraig,
                "일라이저 크레이그 스트레이트 라이",
                "100,400원",
                "1700년대 실존인물이자 미국 버번의 아버지로 불리는 일라이저 크레이그의 이름을 따 만든 위스키로, 스파이시한 라이의 특징과 달콤한 옥수수 풍미를 조화롭게 구현해 강한 풍미와 부드러움의 완벽한 균형을 선사한다. \n" +
                    "\n" +
                    "다크초콜릿, 스모키 향이 먼저 나타나며 달콤한 꿀, 오크 풍미가 우아하게 어우러진다. 시나몬부터 검은 후추까지 다양한 향신료 풍미가 입 안을 기분 좋게 자극하며 버터처럼 매끄러운 텍스쳐와 스모키한 맛이 긴 여운을 남긴다. \n" +
                    "\n" +
                    "2021년 San Francisco World Spirits Competition에서 더블 골드 메달을 수상했으며, 2020년 <Whisky Advocate>가 뽑은 TOP 10 위스키 중 7위에 오르며 명성을 얻었다.  ",
                WhiskeyTaste.HIGH,
                bookmark = true,
                favorite = true,
                follow = false
            ),
            WhiskeyDto(
                11,
                currentTime - 11 * TERM_OF_TIME,
                R.drawable.img_elijahcraigsmallbatch,
                "일라이저 크레이그 스몰배치",
                "94,000원",
                "1700년대 실존인물이자 미국 버번의 아버지로 불리는 일라이저 크레이그의 이름을 따 만든 프리미엄 버번 위스키로, 따뜻한 느낌과 스모키한 맛이 특징이다. \n" +
                    "\n" +
                    "윤기있는 구리색을 띄고 있으며, 달콤한 과일과 바닐라 빈, 상큼한 민트의 복합적인 아로마가 느껴진다. 입 안에서 스파이시, 스모키한 강렬한 맛을 즐길 수 있으며, 감미로운 맛과 은은한 우디함이 입 안에 긴 여운으로 남는다. \n" +
                    "\n" +
                    "2021년 샌프란시스코에서 열린 세계 증류주 경쟁대회(San Francisco World Spirits Competition)에서 더블골드 메달을 수상해 그 품질을 인정 받았다. 8~12년 숙성한 위스키를 블렌딩했다.",
                WhiskeyTaste.HIGH,
                bookmark = true,
                favorite = false,
                follow = false
            ),
            WhiskeyDto(
                12,
                currentTime - 12 * TERM_OF_TIME,
                R.drawable.img_elijahcraigtoastedbarrel,
                "일라이저 크레이그 토스티드 배럴",
                "134,000원",
                "700년대 실존인물이자 미국 버번의 아버지로 불리는 일라이저 크레이그의 이름을 따 만든 프리미엄 버번 위스키로, 오크 배럴의 그을린 뉘앙스를 잘 살려 만든 버전이다. \n" +
                    "\n" +
                    "숙성된 위스키를 새 오크 배럴에서 다시 한번 숙성해 복합적인 풍미를 더했으며, 두 번째 숙성 시 사용되는 배럴은 일반적으로 사용되는 배럴(Charred Barrel)보다 부드럽게 토스팅해 달콤한 뉘앙스를 강조했다. \n" +
                    "\n" +
                    "구운 피칸 컬러를 띠고 있으며, 캐러멜과 오크의 달콤한 향, 스모키한 향과 밀크초콜릿처럼 감미로운 텍스쳐를 즐길 수 있다. ",
                WhiskeyTaste.HIGH,
                bookmark = true,
                favorite = false,
                follow = true
            ),
            WhiskeyDto(
                13,
                currentTime - 13 * TERM_OF_TIME,
                R.drawable.img_evanwilliamsbottledinbond,
                "에반 윌리엄스 바틀드 인 본드",
                "53,000원",
                "고소한 곡물의 향과 바닐라, 캐러멜 등 오크 숙성에서 배어나는 다양한 아로마. 입 안에서 살짝 스파이시한 맛과 길게 남는 여운을 천천히 음미할 수 있다. \n" +
                    "\n" +
                    "바틀드 인 본드(Bottled in Bond) 위스키란 1897년에 제정된 법에 따라 미국 재무성이 관리하고 감독하는 표준화된 규격에 맞게 생산되는 위스키를 뜻한다. 주원료를 51% 이상 사용해야 하고 알코올 볼륨은 100프루프로 병입해야 한다. 또한 단일 증류소에서 하나의 증류기로 만든 같은 년도 제품이어야 한다. \n" +
                    "\n" +
                    "에반 윌리엄스의 바틀드 인 본드는 바틀드 인 본드 위스키에서 기대하는 요건과 맛을 충족하면서도 부드러운 맛을 자랑한다. 2021년 San Francisco World Spirits Competition에서 Double Gold Medal 수상하며 그 품질을 인정 받았다. ",
                WhiskeyTaste.MIDDLE,
                bookmark = false,
                favorite = false,
                follow = false
            ),
            WhiskeyDto(
                14,
                currentTime - 14 * TERM_OF_TIME,
                R.drawable.img_parkersheritagecollectionheavycharbarrel,
                "파커스 헤리티지 컬렉션 헤비 샤 배럴",
                "194,000원",
                "파커스 헤리티지는 헤븐힐 디스틸러리의 마스터 디스틸러인 파커 빔(Parker Beam)의 이름을 따 만들어진 위스키다. 버번, 라이, 위트 등 여러 위스키가 있는 배럴 중 최고의 배럴을 선별하여 만들기 때문에, 매쉬빌의 구성은 에디션마다 달라진다. \n" +
                    "\n" +
                    "2020년 출시한 14번째 에디션인 헤비 샤 배럴은 1분 30초 간 불에 그을린(Charred) 오크 배럴을 사용해 만들었다. 일반적으로는 40초 그을린 오크통을 주로 사용하는데, 좀더 오래 그을린 오크통은 위스키에 스모키함과 카라멜, 메이플의 달콤한 향을 덧입혀 깊고 특별한 맛을 자아낸다. 10년간 숙성했으며 냉각이나 여과 없이 120프루프(60도)의 도수로 병입했다. \n" +
                    "\n" +
                    "균형잡힌 과일 아로마와 기분 좋게 달콤한 마멀레이드 풍미, 정향이나 시나몬 등의 다채로운 피니쉬가 입 안에 오래도록 남는다. ",
                WhiskeyTaste.GOOD,
                bookmark = true,
                favorite = true,
                follow = true
            ),
            WhiskeyDto(
                15,
                currentTime - 15 * TERM_OF_TIME,
                R.drawable.img_larcenybarrelproof,
                "라세니 배럴 프루프",
                "194,000원",
                "마치 1870년대의 피츠제럴드가 배럴에 있는 상태의 위스키를 몰래 맛보았을 때처럼, 위트 버번을 가장 순수한 형태로 즐길 수 있는 uncut & straight 타입으로 만든 버전이다. 6~8년간 배럴숙성을 거친 뒤 냉각여과 없이 배럴 프루프 상태로 병입한다. 연 3회 출시하며, 알코올 볼륨은 배치마다 달라진다.  \n" +
                    "\n" +
                    "어두운 세피아 색을 갖고 있으며, 메이플, 시나몬을 뿌려 구운 빵처럼 달콤하고 따듯한 아로마가 느껴진다. 무화과처럼 달콤한 맛과 은은한 헤이즐넛 향을 즐길 수 있다. \n" +
                    "\n" +
                    "라세니의 기본 위스키와 마찬가지로 옥수수를 주 곡물로 해, 라이(rye) 대신 밀을 사용했으며 그 함유량이 맥아보리보다 높아 비슷한 급의 버번 위스키에 비해 월등하게 부드럽고 섬세한 맛을 가졌다. \n" +
                    "\n" +
                    "위스키 전문지 <WHISKY ADVOCATE> 가 선정하는 2020년 올해의 위스키로 뽑혔으며, 이는 밀 함유 위스키로는 최초로 기록된다. ",
                WhiskeyTaste.GOOD,
                bookmark = true,
                favorite = true,
                follow = true
            )
        )

        return WhiskeyResponse(9, whiskeys)
    }
}
