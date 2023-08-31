package com.example.kakaopractice.bookmark

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.kakaopractice.R
import com.example.kakaopractice.adapter.BookMarkAdapter
import com.example.kakaopractice.databinding.FragmentBookmarkBinding
import com.example.kakaopractice.util.BookMarkViewModelFactory
import com.example.kakaopractice.util.InjectUtil

class BookMarkFragment :Fragment(){
    private lateinit var binding: FragmentBookmarkBinding


    private val bookMarkViewModel: BookMarkViewModel by viewModels(
        factoryProducer = {
            BookMarkViewModelFactory(InjectUtil.providerBookMarkRepository(requireContext()))
        }
    )
    private val bookmarkAdapter = BookMarkAdapter(
        onDelete = {
            bookMarkViewModel.deleteBook(it)
        }
    )

    override fun onResume() {
        super.onResume()
        bookMarkViewModel.getFavoriteBooks()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmark, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvFavoriteBooks.adapter = bookmarkAdapter
        bookMarkViewModel.bookMarkBooks.observe(viewLifecycleOwner) {
            bookmarkAdapter.addAll(it)
        }
    }

}

//    BaseFragment<FragmentBookmarkBinding,BookMarkViewState>(R.layout.fragment_bookmark)
//{
//    override val viewModel: BookMarkViewModel(
//
//    )
//
//
//    override fun initUi() {
//
//    }
//
//    override fun onChangedViewState(viewState: BookMarkViewState) {
//
//    }
//}