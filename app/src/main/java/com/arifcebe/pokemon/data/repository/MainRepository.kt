package com.arifcebe.pokemon.data.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.arifcebe.pokemon.data.api.ApiHelper
import com.arifcebe.pokemon.data.model.BaseList
import com.arifcebe.pokemon.data.model.Pokemon
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainRepository {

    val pokemonList = MutableLiveData<List<Pokemon>>()

    fun getPokemonApiCall(): MutableLiveData<List<Pokemon>> {

        val call = ApiHelper.apiService.getPokemons()

        call.enqueue(object : Callback<BaseList<List<Pokemon>>> {
            override fun onResponse(
                call: Call<BaseList<List<Pokemon>>>,
                response: Response<BaseList<List<Pokemon>>>
            ) {
                val pokemons = response.body()
                val baseList = BaseList<List<Pokemon>>(pokemons!!.count,pokemons.next,pokemons.previous,pokemons.results)
                pokemonList.value = baseList.results
            }

            override fun onFailure(call: Call<BaseList<List<Pokemon>>>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })

        return pokemonList
    }
}

