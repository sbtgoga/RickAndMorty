package com.example.rickandmorty.Network


import com.example.rickandmorty.Model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getCharacters(): Call<CharacterResponse>
}