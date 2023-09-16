package com.example.marvelapipractice.data.repo

import com.example.marvelapipractice.network.MarvelService
import com.example.marvelapipractice.network.response.Character
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(private val marvelService: MarvelService) :
    MarvelRepository {
    override suspend fun getCharacters(offset: Int, limit: Int): Response<Character> =
        marvelService.getCharacters(offset = offset, limit = limit)
}