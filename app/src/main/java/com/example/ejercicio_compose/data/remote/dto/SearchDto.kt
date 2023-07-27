package com.example.ejercicio_compose.data.remote.dto

import com.squareup.moshi.Json

data class SearchDto (
    @Json(name = "name") val name: String = ""
    )