package com.arifcebe.pokemon.data.api

import com.arifcebe.pokemon.data.model.BaseList
import com.arifcebe.pokemon.data.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("pokemon")
    fun getPokemons() : Call<BaseList<List<Pokemon>>>
}