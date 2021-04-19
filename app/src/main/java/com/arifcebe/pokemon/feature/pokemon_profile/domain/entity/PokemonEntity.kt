package com.arifcebe.pokemon.feature.pokemon_profile.domain.entity

import com.arifcebe.pokemon.utils.MappingClass

class PokemonEntity(var name: String, var url: String) {

    val id: String = MappingClass.getIdByUrl(url)
    val idLabel: String = MappingClass.generateIdLabel(id)
}
