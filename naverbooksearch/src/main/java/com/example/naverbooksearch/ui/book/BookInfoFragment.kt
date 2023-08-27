package com.example.naverbooksearch.ui.book

import android.annotation.SuppressLint
import android.os.Bundle
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
import com.example.naverbooksearch.databinding.FragmentBookInfoBinding
import com.example.naverbooksearch.util.BookInfoViewModelFactory
import com.example.naverbooksearch.util.InjectUtil
import com.google.android.material.snackbar.Snackbar


class BookInfoFragment : Fragment() {

    private lateinit var binding: FragmentBookInfoBinding

    private val args by navArgs<BookInfoFragmentArgs>()

    private val bookInfoViewModel: BookInfoViewModel by viewModels(
        factoryProducer = {
            BookInfoViewModelFactory(InjectUtil.provideFavoriteBookRepository(requireContext()))
        }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val item = args.item

        binding.webview.apply {
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
            loadUrl(item.link)
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner, WebViewOnBackPressedCallback(binding.webview, onBackPress = {
                findNavController().popBackStack()
            })
        )

        binding.fabFavorite.setOnClickListener {
            bookInfoViewModel.addBookmark(item)
            Snackbar.make(view, "Book has saved", Snackbar.LENGTH_SHORT).show()
        }
    }


    override fun onPause() {
        binding.webview.onPause()
        super.onPause()
    }

    override fun onResume() {
        binding.webview.onResume()
        super.onResume()
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