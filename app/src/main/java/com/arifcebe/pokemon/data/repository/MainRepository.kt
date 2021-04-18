package com.arifcebe.pokemon.data.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arifcebe.pokemon.core.api.ApiHelper
import com.arifcebe.pokemon.core.database.PokemonDatabase
import com.arifcebe.pokemon.data.entity.PokemonEntity
import com.arifcebe.pokemon.data.model.BaseList
import com.arifcebe.pokemon.data.model.PokemonList
import com.arifcebe.pokemon.data.room_model.PokemonRoomModel
import com.arifcebe.pokemon.utils.MappingClass
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
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

    fun getPokemonApiCall(context: Context, offset: Int): LiveData<List<PokemonEntity>> {

        val call = ApiHelper.apiService.getPokemons()
        database = initializeDatabase(context)
        call.enqueue(object : Callback<BaseList<List<PokemonList>>> {
            override fun onResponse(
                call: Call<BaseList<List<PokemonList>>>,
                response: Response<BaseList<List<PokemonList>>>
            ) {
                val pokemons = response.body()
                val baseList = BaseList<List<PokemonList>>(
                    pokemons!!.count,
                    pokemons.next,
                    pokemons.previous,
                    pokemons.results
                )
//                pokemonList.value = baseList.results
                // TODO check internet connection
                val pokemonRoomList: MutableList<PokemonEntity> = ArrayList()
                for (pokemon in baseList.results!!) {
                    val pokemonRoom: PokemonEntity =
                        PokemonEntity(pokemon.name, pokemon.url)
                    pokemonRoomList.add(pokemonRoom)
                }
//                pokemonList.postValue(pokemonRoomList)
                pokemonList.value = pokemonRoomList
            }

            override fun onFailure(call: Call<BaseList<List<PokemonList>>>, t: Throwable) {

            }

        })


        return pokemonList
    }

    fun getData(): List<PokemonList> {
        val call = ApiHelper.apiService.getPokemons()
        var pokemonList: List<PokemonList> = ArrayList<PokemonList>()
        call.enqueue(object : Callback<BaseList<List<PokemonList>>> {
            override fun onResponse(
                call: Call<BaseList<List<PokemonList>>>,
                response: Response<BaseList<List<PokemonList>>>
            ) {
                val pokemons = response.body()
                val baseList = BaseList<List<PokemonList>>(
                    pokemons!!.count,
                    pokemons.next,
                    pokemons.previous,
                    pokemons.results
                )
                pokemonList = baseList.results!!
            }

            override fun onFailure(call: Call<BaseList<List<PokemonList>>>, t: Throwable) {

            }
        })
        return pokemonList
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO
}