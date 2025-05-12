package com.cinncinatiai.rickandmortycharacterlist.network

import com.cinncinatiai.rickandmortycharacterlist.model.CharactersResponseModel
import retrofit2.http.GET

interface CharacterApi {
    @GET("/api/character")
    suspend fun getCharactersResponse(): CharactersResponseModel
}