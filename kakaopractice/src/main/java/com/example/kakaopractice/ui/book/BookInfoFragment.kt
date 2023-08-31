package com.example.kakaopractice.ui.book

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kakaopractice.R
import com.example.kakaopractice.base.BaseFragment
import com.example.kakaopractice.databinding.FragmentBookInfoBinding
import com.example.kakaopractice.util.BookInfoViewModelFactory
import com.example.kakaopractice.util.InjectUtil
import com.google.android.material.snackbar.Snackbar

class BookInfoFragment : BaseFragment<FragmentBookInfoBinding,BookInfoViewState>(R.layout.fragment_book_info)
{


    private val args by navArgs<BookInfoFragmentArgs>()



    override val viewModel: BookInfoViewModel by viewModels(
        factoryProducer = {
            BookInfoViewModelFactory(InjectUtil.providerBookMarkRepository(requireContext()))
        }
    )

    @SuppressLint("SetJavaScriptEnabled")
    override fun initUi() {
        val item = args.item
        binding.webview.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(item.url)
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, WebViewOnBackPressedCallback(binding.webview, onBackPress = {
                findNavController().popBackStack()
            })
        )

        binding.fabFavorite.setOnClickListener {
            viewModel.addBookMark(item)
            Snackbar.make(requireView(), "Book has saved", Snackbar.LENGTH_SHORT).show()
        }
    }



    override fun onChangedViewState(viewState: BookInfoViewState) {
//
//
    }


    class WebViewOnBackPressedCallback(
        private val webView: WebView,
        private val onBackPress: () -> Unit
    ) :
        OnBackPressedCallback(webView.isEnabled) {
        override fun handleOnBackPressed() {
            if (webView.canGoBack()) {
                webView.goBack()
            } else {
                onBackPress()
            }
        }
    }
}
