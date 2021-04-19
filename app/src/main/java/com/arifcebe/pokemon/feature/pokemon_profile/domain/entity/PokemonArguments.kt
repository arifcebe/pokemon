package com.arifcebe.pokemon.feature.pokemon_profile.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonArguments(
    val id: Int,
    val name: String,
    val idLabel: String,
    var species: PokemonSpeciesArguments,
    val abilities: List<String>,
    val stats: List<StatArguments>,
    val image: String,
    val type: String,
    val sprites: List<String>,
): Parcelable

@Parcelize
data class StatArguments(
    val baseStat: Int,
    val effort: Int,
    val statName: String,
): Parcelable

@Parcelize
data class PokemonSpeciesArguments(
    val baseHappiness: Int,
    val captureRate: Int,
    val color: String,
//    val eggGroup: List<String>,
    val flavorTextEntry: String,
): Parcelable