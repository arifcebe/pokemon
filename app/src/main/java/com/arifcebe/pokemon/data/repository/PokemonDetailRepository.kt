package com.arifcebe.pokemon.data.repository

import androidx.lifecycle.MutableLiveData
import com.arifcebe.pokemon.core.api.ApiHelper
import com.arifcebe.pokemon.data.model.PokemonList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PokemonDetailRepository {
    val pokemon = MutableLiveData<PokemonList>()

    fun getPokemonDetail(id: String): MutableLiveData<PokemonList> {
        val api = ApiHelper.apiService.getPokemonDetail(id)
        api.enqueue(object : Callback<PokemonList> {
            override fun onResponse(call: Call<PokemonList>, response: Response<PokemonList>) {
                val response = response.body()
                pokemon.value = response
            }

            override fun onFailure(call: Call<PokemonList>, t: Throwable) {

            }

        })
        return pokemon
    }
}