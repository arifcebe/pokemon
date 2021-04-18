package com.arifcebe.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class AbilityModel(
    val ability: BasicItemModel,
    @SerializedName("is_hidden")
    val isHidden: Boolean = false,
    val slot: Int = 0
)