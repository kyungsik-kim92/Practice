package com.example.kakaopractice.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.kakaopractice.R
import com.example.kakaopractice.SettingFragment
import com.example.kakaopractice.adapter.FragmentPagerAdapter
import com.example.kakaopractice.base.BaseFragment
import com.example.kakaopractice.base.BaseViewModel
import com.example.kakaopractice.ui.bookmark.BookMarkFragment
import com.example.kakaopractice.databinding.FragmentHomeBinding
import com.example.kakaopractice.ui.search.SearchFragment
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : BaseFragment<FragmentHomeBinding, HomeViewState>(R.layout.fragment_home) {

    private val tabConfigurationStrategy =
        TabLayoutMediator.TabConfigurationStrategy { tab, positon ->
            tab.icon = resources.obtainTypedArray(R.array.array_main_tab_icon).getDrawable(positon)
            tab.text = resources.getStringArray(R.array.array_main_tab_text)[positon]
        }


    override val viewModel: HomeViewModel by viewModels()


    override fun initUi() {

        val list = listOf(
            SearchFragment(),
            BookMarkFragment(),
            SettingFragment(),
        )

        val pageAdapter = FragmentPagerAdapter(list, this)

        with(binding) {
            viewPager.adapter = pageAdapter
            TabLayoutMediator(tabLayout, viewPager, tabConfigurationStrategy).attach()
        }

    }

    override fun onChangedViewState(viewState: HomeViewState) {
        when(viewState){
            is HomeViewState.RouteBookInfo -> {
                val action =
                    HomeFragmentDirections.actionHomeFragmentToBookInfoFragment(viewState.item)
                findNavController().navigate(action)
            }
        }
    }
}