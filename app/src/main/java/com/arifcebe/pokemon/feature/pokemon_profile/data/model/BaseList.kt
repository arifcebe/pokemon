package com.arifcebe.pokemon.feature.pokemon_profile.data.model

data class BaseList<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: T?
)