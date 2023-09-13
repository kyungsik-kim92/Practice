package com.example.marvelapipractice.api

import com.example.marvelapipractice.api.constants.Constants
import com.example.marvelapipractice.model.Character
import com.example.marvelapipractice.model.DataX
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url
import java.security.PrivateKey

interface MarvelApiService {

    @GET
    fun getAllCharacters(
        @Url url:String,
        @Query("count") count: Int,
//        @Query("apikey") apikey: String = Constants.API_KEY,
//        @Query("ts") ts: String = Constants.timeStamp,
//        @Query("hash") hash: String =  Constants.hash(),
    ): Call<DataX>
}