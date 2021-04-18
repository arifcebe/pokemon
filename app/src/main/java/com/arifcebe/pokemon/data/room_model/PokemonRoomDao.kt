package com.arifcebe.pokemon.data.room_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface PokemonRoomDao {
    @Query("SELECT * FROM pokemon")
    fun loadAllPokemon(): LiveData<List<PokemonRoomModel>>

    @Query("SELECT * FROM pokemon LIMIT :pageSize OFFSET :pageIndex ")
    fun loadPokemonByLimit(pageSize: Int, pageIndex: Int): LiveData<List<PokemonRoomModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPokemonToRoom(pokemons: List<PokemonRoomModel>)

    @Update
    fun updatePokemon(pokemon: PokemonRoomModel)

    @Delete
    fun deletePokemon(pokemon: PokemonRoomModel)
}