package com.example.rickandmorty.Repository

import com.example.rickandmorty.Network.RetrofitClient

class CharacterRepository {
    fun getCharacters() = RetrofitClient.api.getCharacters()
}