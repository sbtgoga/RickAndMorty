package com.cinncinatiai.rickandmortycharacterlist.ui.charactersscreen

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cinncinatiai.rickandmortycharacterlist.databinding.ActivityMainBinding
import com.cinncinatiai.rickandmortycharacterlist.utils.gone
import com.cinncinatiai.rickandmortycharacterlist.utils.show

class CharactersActivity : AppCompatActivity() {
    private val charactersViewModel: CharactersViewModel by lazy {
        CharactersViewModel()
    }

    private lateinit var binding: ActivityMainBinding
    private var characterAdapter: CharacterAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        characterAdapter = CharacterAdapter()
        binding.recyclerView.apply {
            this.layoutManager = LinearLayoutManager(this@CharactersActivity,LinearLayoutManager.VERTICAL, false)
            this.adapter = characterAdapter
        }
        charactersViewModel.onInit()
        charactersViewModel.uiState.observe(this) { onUIState(it) }

    }

    private fun onUIState(uiState: MainUIState){
        when (uiState){
            is MainUIState.CharacterLoaded -> {
                binding.progressBar.gone()
                characterAdapter?.setCharacters(uiState.characters)
            }
            is MainUIState.ErrorLoading -> {
                binding.progressBar.gone()
                Toast.makeText(this, uiState.error,Toast.LENGTH_LONG).show()
            }
            MainUIState.Loading -> binding.progressBar.show()
            MainUIState.None -> binding.progressBar.gone()
        }
    }

}