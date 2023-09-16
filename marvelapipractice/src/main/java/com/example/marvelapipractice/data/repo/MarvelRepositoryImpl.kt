package com.example.marvelapipractice.data.repo

import com.example.marvelapipractice.network.MarvelService
import com.example.marvelapipractice.network.response.Character
import com.example.marvelapipractice.util.RetrofitInstance
import retrofit2.Response

class MarvelRepositoryImpl(private val marvelService: MarvelService = RetrofitInstance.api) :
    MarvelRepository {
    override suspend fun getCharacters(offset: Int, limit: Int): Response<Character> =
        marvelService.getCharacters(offset = offset, limit = limit)


    companion object {
        private var INSTANCE: MarvelRepository? = null

        fun getInstance(): MarvelRepository =
            INSTANCE ?: MarvelRepositoryImpl().also { INSTANCE = it }
    }

}