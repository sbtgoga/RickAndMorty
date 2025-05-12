package com.cinncinatiai.rickandmortycharacterlist.model

data class CharactersResponseModel(
    val info: InfoModel,
    val results: List<CharacterModel>
)
