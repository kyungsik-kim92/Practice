package com.example.naverbooksearch.ui

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.naverbooksearch.R
import com.example.naverbooksearch.SettingFragment
import com.example.naverbooksearch.adapter.ParentFragmentPagerAdapter
import com.example.naverbooksearch.base.BaseFragment
import com.example.naverbooksearch.databinding.FragmentHomeBinding
import com.example.naverbooksearch.ui.favorite.FavoriteFragment
import com.example.naverbooksearch.ui.search.SearchFragment
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
            FavoriteFragment(),
            SettingFragment(),
        )

        val pageAdapter = ParentFragmentPagerAdapter(list, this)

        with(binding) {
            viewPager.adapter = pageAdapter
            TabLayoutMediator(tabLayout, viewPager, tabConfigurationStrategy).attach()
        }
    }

    override fun onChangedViewState(viewState: HomeViewState) {
        when(viewState){
            is HomeViewState.RouteBookInfo -> {
                val action =
                    HomeFragmentDirections.actionFragmentHomeToFragmentBookInfo(viewState.item)
                findNavController().navigate(action)
            }
        }
    }

}