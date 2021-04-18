package com.arifcebe.pokemon.ui.main.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifcebe.pokemon.data.entity.PokemonEntity
import com.arifcebe.pokemon.data.repository.MainRepository

class MainViewModel : ViewModel() {

    var pokemonListLiveData: MutableLiveData<List<PokemonEntity>>? = null

    fun getPokemons(context: Context, offset: String) : MutableLiveData<List<PokemonEntity>>? {

        pokemonListLiveData = MainRepository.getPokemonApiCall(context, offset)
        return pokemonListLiveData
    }
}
