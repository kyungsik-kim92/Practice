package com.example.marvelapipractice.ui.home

import androidx.lifecycle.viewModelScope
import com.example.marvelapipractice.base.BaseViewModel
import com.example.marvelapipractice.domain.usecase.GetMarvelCharacterUseCase
import com.example.marvelapipractice.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getMarvelCharacterUseCase: GetMarvelCharacterUseCase) :
    BaseViewModel() {

    private var offsetCount = INIT_OFFSET

    private var isStartSearch = AtomicBoolean(false)

    val isScrollBottomPosition: Function1<Boolean, Unit> = { isBottom ->
        if (isBottom && !isStartSearch.get()) {
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
    ) {
        getMarvelCharacterUseCase(offset = offset).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    onChangedViewState(
                        HomeViewState.ShowToast(
                            result.exception?.message ?: "Unknown Error"
                        )
                    )
                    isStartSearch.set(false)
                }

                is Resource.Success -> {
                    offsetCount += result.data.count
                    if (isRefresh) onChangedViewState(HomeViewState.Refresh(result.data.results))
                    else onChangedViewState(HomeViewState.GetData(result.data.results))
                    isStartSearch.set(false)
                }
            }
        }.launchIn(viewModelScope)
    }

    fun refresh() {
        offsetCount = INIT_OFFSET
        getCharacter(isRefresh = true)
    }


    companion object {
        private const val INIT_OFFSET = 0
    }
}





