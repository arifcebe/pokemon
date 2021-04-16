package com.arifcebe.pokemon.utils

import com.arifcebe.pokemon.data.api.ApiHelper

object MappingClass {

    fun getIdByUrl(url: String): String {
        val arraysOfString = url.split("/")
        return arraysOfString[6]
    }

    fun generateProfileImageUrl(id: String): String {
        return "${ApiHelper.IMAGE_BASE_URL}/$id.png"
    }

    fun generateIdLabel(id: String): String {
        var idLabel: String = ""
        if (id.toInt() < 10){
            idLabel = "#00$id"
        } else if (id.toInt() in 10..99){
            idLabel = "#0$id"
        } else {
            idLabel = "#$id"
        }

        return idLabel
    }
}