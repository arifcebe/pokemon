package com.arifcebe.pokemon.data.repository

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.arifcebe.pokemon.core.api.ApiHelper
import com.arifcebe.pokemon.data.entity.Pokemon
import com.arifcebe.pokemon.data.entity.PokemonSpecies
import com.arifcebe.pokemon.data.model.PokemonModel
import com.arifcebe.pokemon.data.model.PokemonSpeciesModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object PokemonDetailRepository {
    val pokemon = MutableLiveData<Pokemon>()

    fun getPokemonDetail(owner: LifecycleOwner, id: String): MutableLiveData<Pokemon> {
        val api = ApiHelper.apiService.getPokemonDetail(id)
        val species = getSpecies(id)
        var speciesPokemon: PokemonSpecies? = null
        species.observe(owner, Observer {
            speciesPokemon = it
            api.enqueue(object : Callback<PokemonModel> {
                override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
//                val response = response.body()
                    val pkm = response.body()?.let { Pokemon(it,speciesPokemon!!) }
                    pokemon.value = pkm
                }

                override fun onFailure(call: Call<PokemonModel>, t: Throwable) {

                }

            })
        })

        /*api.enqueue(object : Callback<PokemonModel> {
            override fun onResponse(call: Call<PokemonModel>, response: Response<PokemonModel>) {
//                val response = response.body()
                val species = getSpecies(id)
                var speciesPokemon: PokemonSpecies? = null
                species.observe(owner, Observer {
                    speciesPokemon = it
                })
                val pkm = response.body()?.let { Pokemon(it,speciesPokemon!!) }
                pokemon.value = pkm
            }

            override fun onFailure(call: Call<PokemonModel>, t: Throwable) {

            }

        })*/
        return pokemon
    }

    fun getSpecies(name: String): MutableLiveData<PokemonSpecies> {
        val call = ApiHelper.apiService.getSpecies(name)
        val species = MutableLiveData<PokemonSpecies>()
        call.enqueue(object : Callback<PokemonSpeciesModel>{
            override fun onResponse(
                call: Call<PokemonSpeciesModel>,
                response: Response<PokemonSpeciesModel>
            ) {
                species.value = response.body().let { PokemonSpecies(it!!) }

            }

            override fun onFailure(call: Call<PokemonSpeciesModel>, t: Throwable) {
            }

        })
        return species
    }
}