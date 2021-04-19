package com.arifcebe.pokemon.feature.pokemon_profile.data.model

import com.google.gson.annotations.SerializedName

data class TypeModel(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: BasicItemModel
)