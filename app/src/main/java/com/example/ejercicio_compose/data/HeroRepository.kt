package com.example.ejercicio_compose.data

import com.example.ejercicio_compose.domain.model.HeroModel
import com.example.ejercicio_compose.domain.model.LocationModel

interface HeroRepository {
    suspend fun getHeroList(): List<HeroModel>
    suspend fun getHeroDetailById(id: String): HeroModel
    suspend fun getHeroLocationList(id: String): List<LocationModel>
}