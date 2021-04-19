package com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_detail.viewmodel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.Pokemon
import com.arifcebe.pokemon.feature.pokemon_profile.data.repositories.PokemonDetailRepository

class PokemonDetailViewModel : ViewModel() {
    var pokemonLiveData: MutableLiveData<Pokemon>? = null

    fun pokemonDetail(owner: LifecycleOwner, id: String): LiveData<Pokemon>? {
        pokemonLiveData = PokemonDetailRepository.getPokemonDetail(owner, id)
        return pokemonLiveData
    }
}
