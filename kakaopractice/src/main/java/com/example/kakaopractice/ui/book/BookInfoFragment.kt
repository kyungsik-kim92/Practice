package com.example.kakaopractice.ui.book

import android.annotation.SuppressLint
import android.util.Log
import android.webkit.WebViewClient
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kakaopractice.MainViewModel
import com.example.kakaopractice.R
import com.example.kakaopractice.base.BaseFragment
import com.example.kakaopractice.databinding.FragmentBookInfoBinding
import com.example.kakaopractice.home.HomeViewModel
import com.example.kakaopractice.network.response.KakaoBookItem
import com.example.kakaopractice.util.WebViewOnBackPressedCallback
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookInfoFragment :
    BaseFragment<FragmentBookInfoBinding, BookInfoViewState>(R.layout.fragment_book_info) {


    private val args by navArgs<BookInfoFragmentArgs>()

    override val viewModel: BookInfoViewModel by viewModels()

    private val mainViewModel by activityViewModels<MainViewModel>()


    @SuppressLint("SetJavaScriptEnabled")
    override fun initUi() {
        val item = args.item
        with(binding){
            webview.apply {
                webViewClient = WebViewClient()
                settings.javaScriptEnabled = true
            }
            viewModel = this@BookInfoFragment.viewModel
            bookItem = item
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, WebViewOnBackPressedCallback(binding.webview, onBackPress = {
                findNavController().popBackStack()
            })
        )
    }


    override fun onChangedViewState(viewState: BookInfoViewState) {
        when (viewState) {
            is BookInfoViewState.AddBookmarkResult -> {
                if (viewState.result) {
                    Snackbar.make(requireView(), "북마크에 추가 되었습니다.", Snackbar.LENGTH_SHORT).show()
                    mainViewModel.addBookmark(viewState.item)
                } else {
                    Snackbar.make(requireView(), "북마크에 추가를 실패하였습니다.", Snackbar.LENGTH_SHORT).show()
                }
            }

            is BookInfoViewState.DeleteBookmarkResult -> {
                if (viewState.result) {
                    Snackbar.make(requireView(), "북마크에 해제 되었습니다.", Snackbar.LENGTH_SHORT).show()
                    mainViewModel.deleteBookmark(viewState.item)
                } else {
                    Snackbar.make(requireView(), "북마크에 해제를 실패하였습니다.", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

}

