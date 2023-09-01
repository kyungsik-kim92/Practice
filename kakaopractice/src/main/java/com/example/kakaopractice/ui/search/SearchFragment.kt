package com.example.kakaopractice.ui.search

import androidx.fragment.app.viewModels
import com.example.kakaopractice.R
import com.example.kakaopractice.adapter.SearchBookAdapter
import com.example.kakaopractice.base.BaseFragment
import com.example.kakaopractice.databinding.FragmentSearchBinding
import com.example.kakaopractice.home.HomeViewModel
import com.example.kakaopractice.ui.book.BookInfoViewModel
import com.example.kakaopractice.util.BookInfoViewModelFactory
import com.example.kakaopractice.util.InjectUtil


class SearchFragment :
    BaseFragment<FragmentSearchBinding, SearchViewState>(R.layout.fragment_search) {

    override val viewModel: SearchViewModel by viewModels(
        factoryProducer = { SearchViewModelProviderFactory() }
    )
    private val homeViewModel by viewModels<HomeViewModel>(
        ownerProducer = { requireParentFragment() }
    )

    private val bookInfoViewModel: BookInfoViewModel by viewModels(
        factoryProducer = {
            BookInfoViewModelFactory(InjectUtil.providerBookMarkRepository(requireContext()))
        }
    )

    private val searchBookAdapter = SearchBookAdapter(
        onItemClick = {
            homeViewModel.routeBookInfo(it)
        },
        onBookMarkInsertClick = { bookInfoViewModel.addBookMark(it) },
        onBookMarkDeleteClick = { bookInfoViewModel.deleteBookMark(it) })


    override fun initUi() {
        binding.viewModel = this@SearchFragment.viewModel
        binding.rvSearchResult.adapter = searchBookAdapter


    }

    override fun onChangedViewState(viewState: SearchViewState) {
        when (viewState) {
            is SearchViewState.GetSearchResult -> {
                searchBookAdapter.addAll(viewState.list)
            }

            is SearchViewState.BookMarkResult -> {


            }
        }
    }


}