package com.example.ejercicio_compose.data.mappers

import com.example.ejercicio_compose.data.remote.dto.LocationDto
import com.example.ejercicio_compose.domain.model.LocationModel

fun LocationDto.toLocationModel() = LocationModel(
    latitude = latitud!!.toDouble(),
    longitude = longitud!!.toDouble()
)