package com.example.marvelapipractice.constants

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp


object Constants {

    const val BASE_URL = "https://gateway.marvel.com/"
    const val API_KEY = "f725a3049526b28d755e1b0e3d508abc"
    const val PRIVATE_KEY = "ded2a4c1deddb5f28cba26c444f1380a48b08ddd"
//    const val HASH = "b5a6617013dac501e5a46727afa12388"

    val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

    fun hash(): String{
        val input = "$timeStamp$PRIVATE_KEY$API_KEY"
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
    }

}