package com.cinncinatiai.rickandmortycharacterlist.repository

import com.cinncinatiai.rickandmortycharacterlist.model.CharactersResponseModel
import com.cinncinatiai.rickandmortycharacterlist.network.CharacterApi
import com.cinncinatiai.rickandmortycharacterlist.network.NetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface CharactersRepository{
    suspend fun getCharactersResponse(): CharactersResponseModel
}
class CharactersRepositoryImpl(
    private val characterApi: CharacterApi = NetworkClient.characterApi
): CharactersRepository {
    override suspend fun getCharactersResponse(): CharactersResponseModel = withContext(Dispatchers.IO){
        return@withContext characterApi.getCharactersResponse()
    }

}