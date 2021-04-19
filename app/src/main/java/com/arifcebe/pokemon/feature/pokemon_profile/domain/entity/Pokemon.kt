package com.arifcebe.pokemon.feature.pokemon_profile.domain.entity
import android.os.Parcelable
import android.util.Log
import com.arifcebe.pokemon.feature.pokemon_profile.data.model.PokemonModel
import com.arifcebe.pokemon.feature.pokemon_profile.data.model.StatModel
import com.arifcebe.pokemon.utils.MappingClass
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

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
    val sprites: List<String>
        get() {
            val normal: String = pokemon.sprites.frontDefault
            val shiny: String = pokemon.sprites.frontShiny
            val listOfSprites: MutableList<String> = ArrayList()
            listOfSprites.add(normal)
            listOfSprites.add(shiny)
            return listOfSprites
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