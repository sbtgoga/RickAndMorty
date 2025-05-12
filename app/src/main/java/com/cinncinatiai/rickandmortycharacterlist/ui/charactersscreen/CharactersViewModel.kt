package com.cinncinatiai.rickandmortycharacterlist.ui.charactersscreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cinncinatiai.rickandmortycharacterlist.R
import com.cinncinatiai.rickandmortycharacterlist.model.CharacterModel
import com.cinncinatiai.rickandmortycharacterlist.repository.CharactersRepository
import com.cinncinatiai.rickandmortycharacterlist.repository.CharactersRepositoryImpl
import kotlinx.coroutines.launch

class CharactersViewModel(private val characterRepo: CharactersRepository = CharactersRepositoryImpl()): ViewModel() {
    private val _uiState = MutableLiveData<MainUIState>(MainUIState.None)
    val uiState: LiveData<MainUIState> = _uiState

    fun onInit(){
        _uiState.postValue(MainUIState.Loading)
        viewModelScope.launch {
            try {
                val charactersResponse = characterRepo.getCharactersResponse()
                _uiState.postValue(MainUIState.CharacterLoaded(charactersResponse.results))
            } catch (err: Throwable){
                err.printStackTrace()
                _uiState.postValue(MainUIState.ErrorLoading(R.string.error_generic))
            }
        }
    }
}

sealed class MainUIState{
    data object None: MainUIState()
    data object Loading: MainUIState()
    data class CharacterLoaded(val characters: List<CharacterModel>) : MainUIState()
    data class ErrorLoading(val error: Int) : MainUIState()
}