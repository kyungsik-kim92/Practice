package com.example.marvelapipractice.api

import com.example.marvelapipractice.model.Character
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelApiService {

    @GET("/v1/public/characters")
    fun getAllCharacters(

    ) : Character
}