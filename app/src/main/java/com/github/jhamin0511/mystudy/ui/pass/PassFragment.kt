package com.github.jhamin0511.mystudy.ui.pass

import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.github.jhamin0511.app.common.ui.BaseFragment
import com.github.jhamin0511.mystudy.R
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyDto
import com.github.jhamin0511.mystudy.data.dto.whiskey.WhiskeyTaste
import com.github.jhamin0511.mystudy.databinding.FragmentPassBinding
import dagger.hilt.android.AndroidEntryPoint

@Suppress("MaxLineLength")
@AndroidEntryPoint
class PassFragment : BaseFragment(R.layout.fragment_pass) {
    private lateinit var binding: FragmentPassBinding
    private val whiskey = WhiskeyDto(
        1,
        System.currentTimeMillis(),
        R.drawable.img_jimbeam,
        "짐빔",
        "40,680원",
        "오랜 역사와 전통을 자랑하는 짐빔은 미국 버번위스키를 대표하는 브랜드입니다. 그 중에서도 '짐빔 화이트'는 엄청난 가성비를 지닌 제품입니다. 버번의 개성을 갖췄으면서도 저렴한 가격 덕에 전 세계에서 사랑받고 있으며 미국의 소주라고도 불릴 수 있을만큼 대중적인 술입니다. 스트레이트로 마셔도 좋지만, 탄산수나 콜라를 섞어 마시는 것도 추천드립니다. 오늘, 기분좋게 취하고 싶다면 짐빔과 함께하시는건 어떨까요.",
        "18세기 후기에, 나중엔 결국 자신의 성을 “Beam”으로 바꾼 Boehm 가족의 일원은 독일을 떠나 켄터키주에 정착하였다. 요한네스 레지널드 빔(Johannes Reginald Beam) (1770–1834)은 지금 우리가 버번 위스키라고 알고 있는 위스키를 생산한 농부이다. 제이콥 빔 (Jacob Beam)은 1795년 그가 처음으로 만든 콘 위스키를 팔았다. 그 위스키는 처음에는 올드 제이크 빔(Old Jake Beam)이라고 불렸다. 그리고 증류주공장은 올드 텁(Old Tub)이라고 알려져 있었다.\n" +
            "\n" +
            "데이비드 빔 (David Beam) (1802–1854)은 1820년 18 살이라는 나이에 아버지의 의무를 받아 산업 혁명 시기에 가족의 버번 위스키의 배포를 확산시켰다. 1854년 데이비드 빔 (David M. Beam)(1833–1913)은 각 시로 연결되어 있는 철도를 이용하기 위해 증류 제조공장을 넬슨컨트리로 옮겼다. 제임스 보르가드 빔(James Beauregard Beam) (1864–1947)은 가족의 상업을 미국 금주법기간 전과 후에 이어 관리를 하였다, 그리고 1933년 그는 증류공장을 그의 Bardstown 집에 가까운 Clermont, Kentucky 에다가 다시 건설하였다. 1935년 제임스 빔 주류업체 (James B. Beam Distilling Company)가 해리 호멜(Harry L. Homel), 올리버 제이콥슨 (Oliver Jacobson), 블럼(H. Blum)과 제르마이아 빔(Jerimiah Beam)에 의해 설립되었다. 이 시점 이후로 버번 위스키는 제임스 보르가드 빔(James Beauregard Beam)을 이어 짐 빔 버번(Jim Beam Bourbon)이라고 불렸다, 그리고 몇몇 술병의 라벨에는 제임스 빔 (James B. Beam)의 서명과 함께 “자신의 서명 없는 술은 진짜가 아니다” 라는 내용을 써놓았다. 1913년 제르마이아 빔(Jerimiah Beam) (1899–1977)은 Clear Springs 증류주공장에서 일하기 시작했다, 그 후 그는 새로운 Clermont 시설에서 증류장과 작업 감독관이 되었다. 1954년 제르마이아 빔(Jerimiah Beam)은 완전한 소유권을 얻고 켄터키 보스턴에 제2의 증류 제조공장을 열었다. 제르마이아는 유년시절 친구인 짐버레인 요셉 퀸(Jimberlain Joseph Quinn)과 한 팀을 이뤄 기업을 확장해 나갔다.\n" +
            "\n" +
            "부커 노(Booker Noe) (1929–2004)는 짐 빔 주류업체에서 40년 넘게 제리 달톤(Jerry Dalton) (1998–2007)과 가깝게 지내며 증류장 일을 맡아왔다. 1987년 부커 노는 자신의 이름은 딴 회사의 첫 \"Small Batch Bourbon Collection\" 위스키 부커스Boooker’s를 선보였다\n" +
            "\n" +
            "프레드 노(Fred Noe) (1957–present)는 2007년 제7대 짐 가족 증류자가 되었다, 그리고 그는 정규적으로 판매촉진의 목적으로 여행을 다녔다.\n" +
            "\n" +
            "1987년 짐 빔(Jim Beam)은 내셔널 브랜드(National Brands)를 사들였다.\n" +
            "\n" +
            "빔 가족은 헤븐 힐 제조사(Heaven Hill Distillery)의 역사에서 큰 역할을 했다. 헤븐 힐 창사이래 모든 증류장은 빔 가족의 일원이었다. 헤븐 힐의 원조 증류장은 짐 빔(Jim Beam)의 첫 사촌인 요셉 빔 (Joseph L. Beam)이다. 그의 아들 해리 빔(Harry Beam)은 그의 뒤를 이었고 짐 빔(Jim Beam) 동생의 아들을 이어 얼 빔(Earl Beam)은 요셉 빔 (Joseph L. Beam)의 아들 해리 빔(Harry Beam)를 이었다. 얼 빔(Earl Beam) 은 헤븐 힐 제조사 (Heaven Hill Distillery) 파커 빔(Parker Beam) 과 그의 아들 크레이그 빔(Craig Beam)이 뒤를 이었다.",
        WhiskeyTaste.ROW,
        bookmark = false,
        favorite = false,
        follow = true
    )

    override fun initValue() {
        // no-op comment in an unused listener function
    }

    override fun initView(view: View) {
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
    }

    override fun initObserve() {
        // no-op comment in an unused listener function
    }

    override fun initEvent() {
        binding.btActivityIntent.setOnClickListener {
            val intent = PassedActivity.start(requireContext(), whiskey)
            startActivity(intent)
        }
        binding.btFragmentArgument.setOnClickListener {
            val intent = PassedFragActivity.start(requireContext(), whiskey)
            startActivity(intent)
        }
        binding.btFragmentSafeArgs.setOnClickListener {
            val action =
                PassFragmentDirections.actionPassFragmentToPassedNaviFragment(whiskey)
            findNavController().navigate(action)
        }
    }
}
