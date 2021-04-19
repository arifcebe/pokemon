package com.arifcebe.pokemon.feature.pokemon_profile.data.model

import com.google.gson.annotations.SerializedName

data class SpritesModel(
    @SerializedName("back_default")
    val backDefault: String,
    @SerializedName("back_shiny")
    val backShiny: String,
    @SerializedName("front_default")
    val frontDefault: String,
    @SerializedName("front_shiny")
    val frontShiny: String,
)