package com.example.ejercicio_compose.data.mappers

import com.example.ejercicio_compose.data.local.model.HeroLocal
import com.example.ejercicio_compose.data.remote.dto.HeroDto
import com.example.ejercicio_compose.domain.model.HeroModel

fun HeroDto.toHeroModel() = HeroModel(
    id = id ?:"",
    name = name ?: "",
    photoUrl = photo ?: "",
    description = description ?: ""
)

fun HeroDto.toHeroLocal() = HeroLocal(
    id = id ?: "",
    name = name ?: "",
    photoUrl = photo ?: "",
    favorite = favorite ?: false,
    description = description ?: ""
)

fun HeroLocal.toHeroModel() = HeroModel(
    id = id,
    name = name,
    photoUrl = photoUrl,
    description = description
)