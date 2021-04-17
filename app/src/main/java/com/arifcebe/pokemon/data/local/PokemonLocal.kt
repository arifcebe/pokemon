package com.arifcebe.pokemon.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity
data class PokemonLocal(@ColumnInfo(name = "name") val name: String?,
                        @ColumnInfo(name = "name") val url: String?)
