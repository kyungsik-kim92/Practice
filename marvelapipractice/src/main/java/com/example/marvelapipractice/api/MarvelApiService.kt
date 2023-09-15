package com.example.marvelapipractice.api

import com.example.marvelapipractice.network.response.Character
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface MarvelApiService {

    @GET
    suspend fun getAllCharacters(
        @Url url:String,
//        @Query("count") offset: Int = 0,
//        @Query("apikey") apikey: String = Constants.API_KEY,
//        @Query("ts") ts: String = Constants.timeStamp,
//        @Query("hash") hash: String =  Constants.hash(),
    ): Response<Character>
}