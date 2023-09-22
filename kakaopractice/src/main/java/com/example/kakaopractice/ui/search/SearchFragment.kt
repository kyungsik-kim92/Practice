package com.example.kakaopractice.ui.search

import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.kakaopractice.MainViewModel
import com.example.kakaopractice.MainViewState
import com.example.kakaopractice.R
import com.example.kakaopractice.adapter.SearchBookAdapter
import com.example.kakaopractice.base.BaseFragment
import com.example.kakaopractice.base.ViewEvent
import com.example.kakaopractice.databinding.FragmentSearchBinding
import com.example.kakaopractice.home.HomeViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment :
    BaseFragment<FragmentSearchBinding>(R.layout.fragment_search) {

    override val viewModel: SearchViewModel by viewModels()
    private val homeViewModel by viewModels<HomeViewModel>(
        ownerProducer = { requireParentFragment() }
    )


    private val mainViewModel by activityViewModels<MainViewModel>()


    private val searchBookAdapter = SearchBookAdapter(
        onItemClick = {
            homeViewModel.routeBookInfo(it)
        },
        onBookMarkInsertClick = { item ->
            viewModel.addBookMark(item)
        },
        onBookMarkDeleteClick = { item ->
            viewModel.deleteBookMark(item)
        }
    )


    override fun initUi() {
        binding.viewModel = this@SearchFragment.viewModel
        binding.rvSearchResult.adapter = searchBookAdapter

        mainViewModel.viewStateLiveData.observe(requireActivity()) { viewState ->
            (viewState as? MainViewState)?.let {
                when (viewState) {
                    is MainViewState.AddBookmark -> {
                        searchBookAdapter.addBookmark(viewState.item)
                    }

                    is MainViewState.DeleteBookmark -> {
                        searchBookAdapter.deleteBookmark(viewState.item)
                    }
                }
            }
        }
    }

    override fun onChangedUiEvent(viewEvent: ViewEvent) {


    }

    override fun onChangedViewState(viewState: SearchViewState) {
        when (viewState) {
            is SearchViewState.GetSearchResult -> {
                searchBookAdapter.addAll(viewState.list)
            }

            is SearchViewState.AddBookmarkResult -> {
                if (viewState.result) {
                    Snackbar.make(requireView(), "북마크에 추가 되었습니다.", Snackbar.LENGTH_SHORT).show()
                    searchBookAdapter.addBookmark(viewState.item)
                } else {
                    Snackbar.make(requireView(), "북마크에 추가를 실패하였습니다.", Snackbar.LENGTH_SHORT).show()
                }

            }

            is SearchViewState.DeleteBookmarkResult -> {
                if (viewState.result) {
                    Snackbar.make(requireView(), "북마크에 해제 되었습니다.", Snackbar.LENGTH_SHORT).show()
                    searchBookAdapter.deleteBookmark(viewState.item)
                } else {
                    Snackbar.make(requireView(), "북마크에 해제를 실패하였습니다.", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }


}