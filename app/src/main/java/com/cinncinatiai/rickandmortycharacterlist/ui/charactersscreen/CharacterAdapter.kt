package com.cinncinatiai.rickandmortycharacterlist.ui.charactersscreen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cinncinatiai.rickandmortycharacterlist.databinding.CardViewDesignBinding
import com.cinncinatiai.rickandmortycharacterlist.model.CharacterModel

class CharacterAdapter: RecyclerView.Adapter<CharacterViewHolder>(){
    private val items = mutableListOf<CharacterModel>()

    fun setCharacters(characters: List<CharacterModel>){
        items.clear()
        items.addAll(characters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = CardViewDesignBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindDataToView(items[position])
    }

}