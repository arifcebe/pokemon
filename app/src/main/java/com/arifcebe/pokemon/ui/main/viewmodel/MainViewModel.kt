package com.arifcebe.pokemon.ui.main.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arifcebe.pokemon.data.entity.PokemonEntity
import com.arifcebe.pokemon.data.model.PokemonList
import com.arifcebe.pokemon.data.repository.MainRepository
import com.arifcebe.pokemon.data.room_model.PokemonRoomModel

class MainViewModel : ViewModel() {

    var pokemonListLiveData: LiveData<List<PokemonEntity>>? = null

    fun getPokemons(context: Context, offset: Int) : LiveData<List<PokemonEntity>>? {

        pokemonListLiveData = MainRepository.getPokemonApiCall(context, offset)
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
