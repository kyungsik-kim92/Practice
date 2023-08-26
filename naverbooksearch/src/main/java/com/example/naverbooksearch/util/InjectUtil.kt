package com.example.naverbooksearch.util

import com.example.naverbooksearch.data.repo.FavoriteBookRepository
import com.example.naverbooksearch.data.repo.FavoriteBookRepositoryImpl
import com.example.naverbooksearch.data.repo.SearchBookRepository
import com.example.naverbooksearch.data.repo.SearchBookRepositoryImpl

object InjectUtil {


    fun provideSearchBookRepository(): SearchBookRepository =
        SearchBookRepositoryImpl()

//    fun provideFavoriteBookRepository(): FavoriteBookRepository =
//        FavoriteBookRepositoryImpl()
//

}