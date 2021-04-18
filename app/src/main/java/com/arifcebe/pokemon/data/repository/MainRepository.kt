package com.arifcebe.pokemon.data.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.arifcebe.pokemon.core.api.ApiHelper
import com.arifcebe.pokemon.core.database.PokemonDatabase
import com.arifcebe.pokemon.data.entity.PokemonEntity
import com.arifcebe.pokemon.data.entity.PokemonSpecies
import com.arifcebe.pokemon.data.model.BaseList
import com.arifcebe.pokemon.data.model.PokemonModel
import com.arifcebe.pokemon.data.model.PokemonSpeciesModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

object MainRepository : CoroutineScope {

    var database: PokemonDatabase? = null
//    var pokemonList: LiveData<List<PokemonEntity>>? = null

    val pokemonList = MutableLiveData<List<PokemonEntity>>()
    private fun initializeDatabase(context: Context): PokemonDatabase {
        return PokemonDatabase.getDataseClient(context)
    }

    fun getPokemonApiCall(context: Context, offset: String): MutableLiveData<List<PokemonEntity>> {

        val call = ApiHelper.apiService.getPokemons(offset,20.toString())
        database = initializeDatabase(context)
        call.enqueue(object : Callback<BaseList<List<PokemonModel>>> {
            override fun onResponse(
                call: Call<BaseList<List<PokemonModel>>>,
                response: Response<BaseList<List<PokemonModel>>>
            ) {
                val pokemons = response.body()
                val baseList = BaseList<List<PokemonModel>>(
                    pokemons!!.count,
                    pokemons.next,
                    pokemons.previous,
                    pokemons.results
                )

                val pokemonRoomList: MutableList<PokemonEntity> = ArrayList()
                for (pokemon in baseList.results!!) {
                    val pokemonRoom: PokemonEntity =
                        PokemonEntity(pokemon.name, pokemon.url)
                    pokemonRoomList.add(pokemonRoom)
                }
                pokemonList.postValue(pokemonRoomList)
                //pokemonList.value = pokemonRoomList
            }

            override fun onFailure(call: Call<BaseList<List<PokemonModel>>>, t: Throwable) {

            }

        })


        return pokemonList
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}