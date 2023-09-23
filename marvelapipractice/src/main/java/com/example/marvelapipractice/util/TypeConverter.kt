package com.example.marvelapipractice.util

import androidx.room.ProvidedTypeConverter
import com.example.marvelapipractice.network.response.Comics
import androidx.room.TypeConverter
import com.example.marvelapipractice.network.response.Item
import com.example.marvelapipractice.network.response.Url
import com.google.gson.Gson

@ProvidedTypeConverter
class UrlTypeConverter(private val gson: Gson) {

    @TypeConverter
    fun listToJson(value: List<Url>?) = gson.toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = gson.fromJson(value, Array<Url>::class.java).toList()
}


@ProvidedTypeConverter
class ItemTypeConverter(private val gson: Gson) {

    @TypeConverter
    fun listToJson(value: List<Item>?) = gson.toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = gson.fromJson(value, Array<Item>::class.java).toList()


}




