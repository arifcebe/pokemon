package com.arifcebe.pokemon.feature.pokemon_profile.data.model

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesModel(
    @SerializedName("base_happiness")
    val baseHappiness: Int,
    @SerializedName("capture_rate")
    val captureRate: Int,
    val color: BasicItemModel,
    @SerializedName("egg_group")
    val eggGroup: List<BasicItemModel>,
    @SerializedName("flavor_text_entries")
    val flavorTextEntry: List<FlavorTextEntryModel>
)

data class FlavorTextEntryModel (
    @SerializedName("flavor_text")
    val flavorText: String,
    val language: BasicItemModel,
    val version: BasicItemModel,
)