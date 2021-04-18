package com.arifcebe.pokemon.data.entity
import android.util.Log
import com.arifcebe.pokemon.data.model.PokemonModel
import com.arifcebe.pokemon.data.model.StatModel
import com.arifcebe.pokemon.utils.MappingClass

class Pokemon(val pokemon: PokemonModel, val pokemonSpecies: PokemonSpecies) {

    val id: Int = pokemon.id
    val name: String = pokemon.name
    val idLabel: String = MappingClass.generateIdLabel(id.toString())
    var species: PokemonSpecies = pokemonSpecies
    val abilities: List<String>
        get() {
            return pokemon.abilities.map { a -> a.ability.name }.toList()
        }
    val stats: List<Stat>
        get() {
            return pokemon.stats.map { s -> Stat(s) }.toList()
        }
    val image: String
        get() {
            return MappingClass.generateProfileImageUrl(id.toString())
        }
    val type: String
        get() {
            Log.d("Debug","type name ${pokemon.types.last().slot}")
            return pokemon.types.last().type.name
        }
}

class Stat(private val stat: StatModel){
    val baseStat: Int = stat.baseStat
    val effort: Int = stat.effort
    val statName: String
        get() {
            return stat.stat.name
        }
}