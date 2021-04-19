package com.arifcebe.pokemon.feature.pokemon_profile.presentation.pokemon_list.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifcebe.pokemon.feature.pokemon_profile.domain.entity.PokemonEntity
import com.arifcebe.pokemon.feature.pokemon_profile.data.repositories.MainRepository

class MainViewModel : ViewModel() {

    var pokemonListLiveData: MutableLiveData<List<PokemonEntity>>? = null

    fun getPokemons(context: Context, offset: String) : MutableLiveData<List<PokemonEntity>>? {

        pokemonListLiveData = MainRepository.getPokemonApiCall(context, offset)
        return pokemonListLiveData
    }
}
