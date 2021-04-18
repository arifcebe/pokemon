package com.arifcebe.pokemon.ui.main.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifcebe.pokemon.data.entity.Pokemon
import com.arifcebe.pokemon.data.repository.PokemonDetailRepository

class PokemonDetailViewModel : ViewModel() {
    var pokemonLiveData: MutableLiveData<Pokemon>? = null

    fun pokemonDetail(owner: LifecycleOwner, id: String): LiveData<Pokemon>? {
        pokemonLiveData = PokemonDetailRepository.getPokemonDetail(owner, id)
        return pokemonLiveData
    }
}
