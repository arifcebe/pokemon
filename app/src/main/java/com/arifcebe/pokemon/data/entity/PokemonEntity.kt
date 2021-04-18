package com.arifcebe.pokemon.data.entity

import com.arifcebe.pokemon.utils.MappingClass

class PokemonEntity(var name: String, var url: String) {
    var id: String = ""
        get() = field
        set(value) {
            field = MappingClass.getIdByUrl(url)
        }

}