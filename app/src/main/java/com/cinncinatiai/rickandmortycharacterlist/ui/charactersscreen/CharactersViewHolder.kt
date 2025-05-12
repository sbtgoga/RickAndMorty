package com.cinncinatiai.rickandmortycharacterlist.ui.charactersscreen

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.cinncinatiai.rickandmortycharacterlist.databinding.CardViewDesignBinding
import com.cinncinatiai.rickandmortycharacterlist.model.CharacterModel

class CharacterViewHolder(val item: CardViewDesignBinding): RecyclerView.ViewHolder(item.root){
    fun bindDataToView(character: CharacterModel){
        item.textView.text = character.name
        item.speciesText.text = character.species
        Glide.with(item.root.context).load(character.image).into(item.imageview)
    }
}
