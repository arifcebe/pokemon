package com.arifcebe.pokemon.data.model

import com.google.gson.annotations.SerializedName

data class TypeModel(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: BasicItemModel
)