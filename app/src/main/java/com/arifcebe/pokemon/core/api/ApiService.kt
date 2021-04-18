package com.arifcebe.pokemon.core.api

import com.arifcebe.pokemon.data.model.BaseList
import com.arifcebe.pokemon.data.model.PokemonList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon")
    fun getPokemons(@Query("offset") offset: String,
                    @Query("limit") limit: String): Call<BaseList<List<PokemonList>>>

    @GET("pokemon/{id}")
    fun getPokemonDetail(@Path("id") id: String): Call<PokemonList>

}