package com.example.rickandmorty.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rickandmorty.Model.CharacterModel
import com.example.rickandmorty.Model.CharacterResponse
import com.example.rickandmorty.Repository.CharacterRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val repository = CharacterRepository()
    private val _characters = MutableLiveData<List<CharacterModel>>()

    init {
        fetchCharacters()
    }

    private fun fetchCharacters() {
        repository.getCharacters().enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ){
                if (response.isSuccessful) {
                    _characters.value = response.body()?.results ?: emptyList()
                } else {
                    Log.e("ViewModel", "Response error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                Log.e("MainViewModel", "Network error", t)
            }
        })
    }
}