package com.example.rickandmorty.Model

data class CharacterResponse(
    val info: Info,
    val results: List<CharacterModel>
)