package com.example.marvelapipractice.ui.home

import androidx.lifecycle.viewModelScope
import com.example.marvelapipractice.base.BaseViewModel
import com.example.marvelapipractice.data.repo.MarvelRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val marvelRepository: MarvelRepository) :
    BaseViewModel() {

    private var offsetCount = INIT_OFFSET

    private var isStartSearch = AtomicBoolean(false)

    val isScrollBottomPosition: Function1<Boolean, Unit> = { isBottom ->
        if(isBottom && !isStartSearch.get()) {
            isStartSearch.set(true)
            getCharacter()
        }
    }

    init {
        getCharacter()
    }

    private fun getCharacter(
        isRefresh: Boolean = false,
        offset: Int = offsetCount,
        limit: Int = LIMIT_COUNT
    ) {
        viewModelScope.launch(IO) {
            val characters = marvelRepository.getCharacters(offset = offset, limit = limit)
            if (characters.isSuccessful) {
                characters.body()?.let {
                    if (isRefresh) onChangedViewState(HomeViewState.Refresh(it.data.results))
                    else {
                        offsetCount += it.data.count
                        onChangedViewState(HomeViewState.GetData(it.data.results))
                    }
                } ?: onChangedViewState(HomeViewState.ShowToast("실패"))
            } else {
                onChangedViewState(HomeViewState.ShowToast("실패"))
            }
            isStartSearch.set(false)
        }

    }

    fun refresh() {
        offsetCount = INIT_OFFSET
        getCharacter(isRefresh = true)
    }



    companion object {
        private const val INIT_OFFSET = 0
        private const val LIMIT_COUNT = 20
    }
}





