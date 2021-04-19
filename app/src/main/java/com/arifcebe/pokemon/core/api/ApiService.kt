package com.arifcebe.pokemon.core.api

import com.arifcebe.pokemon.feature.pokemon_profile.data.model.BaseList
import com.arifcebe.pokemon.feature.pokemon_profile.data.model.PokemonModel
import com.arifcebe.pokemon.feature.pokemon_profile.data.model.PokemonSpeciesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon")
    fun getPokemons(@Query("offset") offset: String,
                    @Query("limit") limit: String): Call<BaseList<List<PokemonModel>>>

    @GET("pokemon/{idOrName}")
    fun getPokemonDetail(@Path("idOrName") idOrName: String): Call<PokemonModel>

    @GET("pokemon-species/{idOrName}")
    fun getSpecies(@Path("idOrName") idOrName: String): Call<PokemonSpeciesModel>

}