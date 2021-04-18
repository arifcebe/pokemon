package com.arifcebe.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class StatModel(
    @SerializedName("base_stat")
    val baseStat: Int = 0,
    val effort: Int = 0,
    val stat: BasicItemModel
)