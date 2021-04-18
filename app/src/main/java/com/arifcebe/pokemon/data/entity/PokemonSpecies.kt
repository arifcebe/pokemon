package com.arifcebe.pokemon.data.entity

import com.arifcebe.pokemon.data.model.BasicItemModel
import com.arifcebe.pokemon.data.model.FlavorTextEntryModel
import com.arifcebe.pokemon.data.model.PokemonSpeciesModel
import com.google.gson.annotations.SerializedName

class PokemonSpecies(private val pokemonSpeciesModel: PokemonSpeciesModel) {
    val baseHappiness: Int = pokemonSpeciesModel.baseHappiness
    val captureRate: Int = pokemonSpeciesModel.captureRate
    val color: String
        get() {
            return pokemonSpeciesModel.color.name
        }
    val eggGroup: List<String>
        get() {
            return pokemonSpeciesModel.eggGroup.map { it.name }.toList()
        }
    val flavorTextEntry: String
        get() {
            return pokemonSpeciesModel.flavorTextEntry.get(0).flavorText
        }
}