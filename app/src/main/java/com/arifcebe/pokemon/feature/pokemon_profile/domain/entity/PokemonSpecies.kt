package com.arifcebe.pokemon.feature.pokemon_profile.domain.entity

import com.arifcebe.pokemon.feature.pokemon_profile.data.model.PokemonSpeciesModel

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