package com.arifcebe.pokemon.data.room_model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
data class PokemonRoomModel(
    @PrimaryKey
    val id: String,
    val name: String,
    val url: String,
)