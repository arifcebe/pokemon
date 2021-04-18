package com.arifcebe.pokemon.core.api

import com.arifcebe.pokemon.data.model.BaseList
import com.arifcebe.pokemon.data.model.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("pokemon")
    fun getPokemons(): Call<BaseList<List<PokemonList>>>

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: String): Call<PokemonList>

}