package com.example.kakaopractice.ui.bookmark

import androidx.fragment.app.viewModels
import com.example.kakaopractice.R
import com.example.kakaopractice.adapter.BookMarkAdapter
import com.example.kakaopractice.base.BaseFragment
import com.example.kakaopractice.databinding.FragmentBookmarkBinding
import com.example.kakaopractice.util.BookMarkViewModelFactory
import com.example.kakaopractice.util.InjectUtil

class BookMarkFragment :BaseFragment<FragmentBookmarkBinding,BookMarkViewState>(R.layout.fragment_bookmark){

    override val viewModel: BookMarkViewModel by viewModels(
        factoryProducer = {
            BookMarkViewModelFactory(InjectUtil.providerBookMarkRepository(requireContext()))
        }
    )
    private val bookmarkAdapter = BookMarkAdapter(
        onDelete = {
            viewModel.deleteBook(it)
        }
    )

    override fun onResume() {
        super.onResume()
        viewModel.getFavoriteBooks()
    }


    override fun initUi() {
        binding.rvFavoriteBooks.adapter = bookmarkAdapter
    }

    override fun onChangedViewState(viewState: BookMarkViewState) {
        when(viewState){
            is BookMarkViewState.BookMarkResult ->{
                bookmarkAdapter.addAll(viewState.list)
            }
        }
    }

}



