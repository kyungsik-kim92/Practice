package com.example.kakaopractice.util

import com.example.kakaopractice.data.repo.SearchBookRepository
import com.example.kakaopractice.data.repo.SearchBookRepositoryImpl

object InjectUtil {

    fun provideSearchBookRepository(): SearchBookRepository =
        SearchBookRepositoryImpl.getInstance()


}