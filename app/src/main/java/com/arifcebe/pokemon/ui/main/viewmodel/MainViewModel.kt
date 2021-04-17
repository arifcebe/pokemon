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

/*
class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {
    private val pokemons = MutableLiveData<Resource<List<Pokemon>>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        fetchPokemon()
    }

    private fun fetchPokemon() {
        pokemons.postValue(Resource.loading(null))
        compositeDisposable.add(
            mainRepository.getPokemons()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ userList ->
                    pokemons.postValue(Resource.success(userList))
                }, { throwable ->
                    pokemons.postValue(Resource.error("Something Went Wrong", null))
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getPokemons(): LiveData<Resource<List<Pokemon>>> {
        return pokemons
    }

}*/
