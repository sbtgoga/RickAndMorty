package com.cinncinatiai.rickandmortycharacterlist.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {

    private const val BASE_URL = "https://rickandmortyapi.com"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val characterApi: CharacterApi by lazy {
        retrofit.create(CharacterApi::class.java)
    }
}