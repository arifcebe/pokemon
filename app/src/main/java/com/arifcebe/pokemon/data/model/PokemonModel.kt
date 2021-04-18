package com.arifcebe.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class PokemonModel(
    @SerializedName("name")
    val name: String = "",
    @SerializedName("url")
    val url: String = "",
    val abilities: ArrayList<AbilityModel>,
    @SerializedName("base_experience")
    val baseExperience: Int = 0,
    val id: Int = 0,
    val species: BasicItemModel,
    val sprites: SpritesModel,
    val stats: List<StatModel>,
    @SerializedName("types")
    val types: List<TypeModel>,
    val weight: Int = 0
)