package com.arifcebe.pokemon.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifcebe.pokemon.data.model.PokemonList
import com.arifcebe.pokemon.data.repository.MainRepository
import com.arifcebe.pokemon.data.repository.PokemonDetailRepository

class PokemonDetailViewModel : ViewModel() {
    var pokemonLiveData: MutableLiveData<PokemonList>? = null

    fun pokemonDetail(id: String): LiveData<PokemonList>? {
        pokemonLiveData = PokemonDetailRepository.getPokemonDetail(id)
        return pokemonLiveData
    }
}
