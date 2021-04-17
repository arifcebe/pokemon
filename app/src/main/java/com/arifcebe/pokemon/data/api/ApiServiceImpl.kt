package com.arifcebe.pokemon.data.api

import com.arifcebe.pokemon.data.model.BaseList
import com.arifcebe.pokemon.data.model.Pokemon

class ApiServiceImpl {
    val BASE_URL = "https://pokeapi.co/api/v2/"
    val IMAGE_BASE_URL = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork"

//    override fun getPokemons(): Single<List<Pokemon>> {
//        return Rx2AndroidNetworking.get("${BASE_URL}/pokemon")
//            .build()
//            .getObjectListSingle(Pokemon::class.java)
//    }

}