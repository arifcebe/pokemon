package com.arifcebe.pokemon.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifcebe.pokemon.data.model.Pokemon
import com.arifcebe.pokemon.data.repository.MainRepository

class MainViewModel : ViewModel() {

    var pokemonListLiveData: MutableLiveData<List<Pokemon>>? = null

    fun getPokemons() : LiveData<List<Pokemon>>? {
        pokemonListLiveData = MainRepository.getPokemonApiCall()
        return pokemonListLiveData
    }
}