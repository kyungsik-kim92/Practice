package com.example.kakaopractice.ui.book

import android.annotation.SuppressLint
import android.webkit.WebViewClient
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.kakaopractice.R
import com.example.kakaopractice.base.BaseFragment
import com.example.kakaopractice.databinding.FragmentBookInfoBinding
import com.example.kakaopractice.util.WebViewOnBackPressedCallback
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookInfoFragment : BaseFragment<FragmentBookInfoBinding,BookInfoViewState>(R.layout.fragment_book_info)
{


    private val args by navArgs<BookInfoFragmentArgs>()


    override val viewModel: BookInfoViewModel by viewModels(

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

        binding.fabFavorite.setOnCheckedChangeListener {_, isChecked ->
            if(isChecked){
            viewModel.addBookMark(item)
            Snackbar.make(requireView(), "북마크에 추가 되었습니다.", Snackbar.LENGTH_SHORT).show()

            }else{
                viewModel.deleteBookMark(item)
                Snackbar.make(requireView(), "북마크에 해제 되었습니다.", Snackbar.LENGTH_SHORT).show()


            }
        }
    }



    override fun onChangedViewState(viewState: BookInfoViewState) {
//
//
    }

}

